package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.AmapWeatherService;
import club.mrxiao.amap.bean.weather.AmapWeatherForecastResult;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoRequest;
import club.mrxiao.amap.bean.weather.AmapWeatherLiveResult;
import club.mrxiao.common.error.AmapErrorException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  天气服务服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
@AllArgsConstructor
public class AmapWeatherServiceImpl implements AmapWeatherService {

    private AmapService amapService;

    @Override
    public List<AmapWeatherLiveResult> liveWeatherInfo(AmapWeatherInfoRequest request) throws AmapErrorException {
        request.setExtensions("base");
        String result = this.amapService.get(INFO,request.toJson());
        return AmapWeatherLiveResult.toList(result);
    }

    @Override
    public List<AmapWeatherForecastResult> forecastWeatherInfo(AmapWeatherInfoRequest request) throws AmapErrorException {
        request.setExtensions("all");
        String result = this.amapService.get(INFO,request.toJson());
        return AmapWeatherForecastResult.toList(result);
    }
}
