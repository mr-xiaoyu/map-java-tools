package club.mrxiao.amap.api;

import club.mrxiao.amap.bean.weather.AmapWeatherForecastResult;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoRequest;
import club.mrxiao.amap.bean.weather.AmapWeatherLiveResult;
import club.mrxiao.common.error.AmapErrorException;

import java.util.List;

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
     * 实况天气信息
     * @param request {@link AmapWeatherInfoRequest}
     * @return {@link AmapWeatherLiveResult}
     * @throws AmapErrorException 错误信息
     */
    List<AmapWeatherLiveResult> liveWeatherInfo(AmapWeatherInfoRequest request) throws AmapErrorException;

    /**
     * 天气预报信息
     * @param request {@link AmapWeatherInfoRequest}
     * @return {@link AmapWeatherForecastResult}
     * @throws AmapErrorException 错误信息
     */
    List<AmapWeatherForecastResult> forecastWeatherInfo(AmapWeatherInfoRequest request) throws AmapErrorException;
}
