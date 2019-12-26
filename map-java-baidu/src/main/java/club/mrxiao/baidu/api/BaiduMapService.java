package club.mrxiao.baidu.api;

import club.mrxiao.baidu.config.BaiduMapConfig;
import club.mrxiao.common.error.BaiduMapErrorException;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *  百度地图api接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
public interface BaiduMapService {

    /**
     * 设置配置
     * @param baiduMapConfig {@link BaiduMapConfig} 配置对象
     */
    void setBaiduMapConfig(BaiduMapConfig baiduMapConfig);

    /**
     * 获取配置
     * @return {@link BaiduMapConfig} 配置对象
     */
    BaiduMapConfig getBaiduMapConfig();

    /**
     * 获取百度地图地点输入提示服务接口
     * @return 百度地图地点输入提示服务接口
     */
    BaiduMapPlaceSuggestionService getBaiduMapPlaceSuggestionService();

    /**
     * 获取百度地图地理编码服务接口
     * @return 百度地图地理编码服务接口
     */
    BaiduMapGeocoderService getBaiduMapGeocoderService();

    /**
     * 发送get请求
     * @param url 请求地址
     * @param jsonParam json对象
     * @return  请求结果
     * @throws BaiduMapErrorException 错误信息
     */
    String get(String url, JSONObject jsonParam) throws BaiduMapErrorException;
}
