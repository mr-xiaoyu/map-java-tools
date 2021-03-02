package club.mrxiao.amap.api;

import club.mrxiao.amap.config.AmapConfig;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *  高德地图api接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
public interface AmapService {

    /**
     * 设置高德地图配置
     * @param config {@link AmapConfig}
     */
    void setAmapConfig(AmapConfig config);


    /**
     * 获取地理/逆地理编码服务接口
     * @return 地理/逆地理编码服务接口
     */
    AmapGeocodeService getAmapGeocodeService();

    /**
     * 获取天气服务服务接口
     * @return 天气服务服务接口
     */
    AmapWeatherService getAmapWeatherService();


    /**
     * 发送get请求
     * @param url 请求地址
     * @param jsonParam json对象
     * @return 请求结果
     */
    String get(String url, JSONObject jsonParam);
}
