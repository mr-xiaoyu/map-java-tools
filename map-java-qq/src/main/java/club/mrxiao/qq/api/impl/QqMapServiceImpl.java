package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapError;
import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.common.utils.StringUtil;
import club.mrxiao.qq.api.QqMapAddressService;
import club.mrxiao.qq.api.QqMapSearchService;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.config.QqMapConfig;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *  腾讯地图api接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-12
 */
public class QqMapServiceImpl implements QqMapService {

    private static final int SUCCESS_STATUS = 0;

    private final Log log = LogFactory.get(this.getClass().getName());

    private QqMapConfig qqMapConfig;

    private final QqMapSearchService qqMapSearchService = new QqMapSearchServiceImpl(this);
    private final QqMapAddressService qqMapAddressService = new QqMapAddressServiceImpl(this);

    @Override
    public void setQqMapConfig(QqMapConfig config) {
        this.qqMapConfig = config;
    }

    @Override
    public QqMapConfig getQqMapConfig() {
        return this.qqMapConfig;
    }

    @Override
    public QqMapSearchService getQqMapSearchService() {
        return this.qqMapSearchService;
    }

    @Override
    public QqMapAddressService getQqMapAddressService() {
        return this.qqMapAddressService;
    }

    @Override
    public String get(String url, JSONObject jsonParam) throws QqMapErrorException {
        String queryString = this.toQueryString(jsonParam);
        url = urlJoint(url);
        if(StrUtil.isNotBlank(queryString)){
            url = url+queryString;
        }
        String result = HttpUtil.get(url);
        log.debug("\n【请求地址】: {}\n【响应数据】：{}", url, result);
        QqMapError error = QqMapError.fromJson(result);
        if(error.getStatus() != SUCCESS_STATUS){
            throw new QqMapErrorException(error);
        }
        return result;
    }

    private String toQueryString(JSONObject data) {
        StringBuilder queryString = new StringBuilder();
        for (String str:data.keySet()) {
            Object item = data.get(str);
            if (item instanceof String) {
                item = StringUtil.utf8encode(item.toString());
            }
            queryString.append("&").append(str).append("=").append(item);
        }
        return queryString.toString();
    }

    private String urlJoint(String url){
        String key = this.qqMapConfig.getKey();
        if(StrUtil.isBlank(url)){
            throw new IllegalArgumentException("url不能为空");
        }
        if(StrUtil.isBlank(key)){
            throw new IllegalArgumentException("key未配置");
        }
        if (url.contains("key=")) {
            throw new IllegalArgumentException("url参数中不允许有key: " + url);
        }
        return url + (url.contains("?") ? "&" : "?") + "key=" + key;
    }
}
