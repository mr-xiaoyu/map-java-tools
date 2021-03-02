package club.mrxiao.amap.api;

import club.mrxiao.amap.bean.weather.AmapWeatherInfoRequest;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoResult;

/**
 * <pre>
 *  天气服务服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
public interface AmapWeatherService {

    /**
     * 天气查询API服务地址
     */
    String INFO = "https://restapi.amap.com/v3/weather/weatherInfo";


    /**
     * 天气信息
     * @param request {@link AmapWeatherInfoRequest}
     * @return {@link AmapWeatherInfoResult}
     */
    AmapWeatherInfoResult weatherInfo(AmapWeatherInfoRequest request);
}
