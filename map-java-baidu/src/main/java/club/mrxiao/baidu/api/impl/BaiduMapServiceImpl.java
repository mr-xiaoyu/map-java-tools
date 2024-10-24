package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.*;
import club.mrxiao.baidu.config.BaiduMapConfig;
import club.mrxiao.common.error.BaiduMapError;
import club.mrxiao.common.error.BaiduMapErrorException;
import club.mrxiao.common.utils.StringUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *     百度地图api接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
public class BaiduMapServiceImpl implements BaiduMapService {

    private final Log log = LogFactory.get(this.getClass().getName());

    private BaiduMapConfig baiduMapConfig;
    private final BaiduMapPlaceSuggestionService placeSuggestionService = new BaiduMapPlaceSuggestionServiceImpl(this);
    private final BaiduMapGeocoderService geocoderService = new BaiduMapGeocoderServiceImpl(this);
    private final BaiduMapPlaceService placeService = new BaiduMapPlaceServiceImpl(this);
    private final BaiduMapGeoconvService geoconvService = new BaiduMapGeoconvServiceImpl(this);

    @Override
    public BaiduMapConfig getBaiduMapConfig() {
        return baiduMapConfig;
    }

    @Override
    public void setBaiduMapConfig(BaiduMapConfig baiduMapConfig) {
        this.baiduMapConfig = baiduMapConfig;
    }

    @Override
    public String get(String url,JSONObject jsonParam) throws BaiduMapErrorException {
        String queryString = this.toQueryString(jsonParam);
        url = urlJoint(url);
        if(StrUtil.isNotBlank(queryString)){
            url = url+queryString;
        }
        String result = HttpUtil.get(url);
        log.debug("\n【请求地址】: {}\n【响应数据】：{}", url, result);
        BaiduMapError error = BaiduMapError.fromJson(result);
        if(error.getStatus() != 0){
            throw new BaiduMapErrorException(error);
        }
        return result;
    }

    @Override
    public BaiduMapPlaceSuggestionService getBaiduMapPlaceSuggestionService() {
        return this.placeSuggestionService;
    }

    @Override
    public BaiduMapGeocoderService getBaiduMapGeocoderService() {
        return this.geocoderService;
    }

    @Override
    public BaiduMapPlaceService getBaiduMapPlaceService() {
        return this.placeService;
    }

    @Override
    public BaiduMapGeoconvService getBaiduMapGeoconvService() {
        return this.geoconvService;
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
        String ak = this.baiduMapConfig.getAk();
        if(StrUtil.isBlank(url)){
            throw new IllegalArgumentException("url不能为空");
        }
        if(StrUtil.isBlank(ak)){
            throw new IllegalArgumentException("ak未配置");
        }
        if (url.contains("ak=")) {
            throw new IllegalArgumentException("url参数中不允许有ak: " + url);
        }
        return url + (url.contains("?") ? "&" : "?") + "ak=" + ak+"&output=json";
    }
}
