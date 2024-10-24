package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapDistrictService;
import club.mrxiao.amap.api.AmapGeocodeService;
import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.AmapWeatherService;
import club.mrxiao.amap.config.AmapConfig;
import club.mrxiao.common.error.AmapError;
import club.mrxiao.common.error.AmapErrorException;
import club.mrxiao.common.utils.StringUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *  高德地图api接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
public class AmapServiceImpl implements AmapService {

    private static final String SUCCESS_STATUS = "1";

    private static final String SUCCESS_CODE = "10000";

    private final Log log = LogFactory.get(this.getClass().getName());

    private AmapConfig amapConfig;
    private final AmapGeocodeService amapGeocodeService = new AmapGeocodeServiceImpl(this);
    private final AmapWeatherService amapWeatherService = new AmapWeatherServiceImpl(this);
    private final AmapDistrictService amapDistrictService = new AmapDistrictServiceImpl(this);


    @Override
    public void setAmapConfig(AmapConfig config) {
        this.amapConfig = config;
    }

    @Override
    public AmapGeocodeService getAmapGeocodeService() {
        return this.amapGeocodeService;
    }

    @Override
    public AmapWeatherService getAmapWeatherService() {
        return this.amapWeatherService;
    }

    @Override
    public AmapDistrictService getAmapDistrictService() {
        return this.amapDistrictService;
    }

    @Override
    public String get(String url, JSONObject jsonParam) throws AmapErrorException {
        String queryString = this.toQueryString(jsonParam);
        url = urlJoint(url);
        if(StrUtil.isNotBlank(queryString)){
            url = url+queryString;
        }
        String result = HttpUtil.get(url);
        log.debug("\n【请求地址】: {}\n【响应数据】：{}", url, result);
        AmapError error = AmapError.fromJson(result);
        if(!SUCCESS_STATUS.equals(error.getStatus()) || !SUCCESS_CODE.equals(error.getInfocode())){
            throw new AmapErrorException(error);
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
        String key = this.amapConfig.getKey();
        if(StrUtil.isBlank(url)){
            throw new IllegalArgumentException("url不能为空");
        }
        if(StrUtil.isBlank(key)){
            throw new IllegalArgumentException("key未配置");
        }
        if (url.contains("key=")) {
            throw new IllegalArgumentException("url参数中不允许有key: " + url);
        }
        return url + (url.contains("?") ? "&" : "?") + "key=" + key+"&output=json";
    }
}
