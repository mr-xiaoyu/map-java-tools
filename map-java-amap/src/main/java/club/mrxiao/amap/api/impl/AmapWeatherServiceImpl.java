package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.AmapWeatherService;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoRequest;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoResult;
import lombok.AllArgsConstructor;

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
    public AmapWeatherInfoResult weatherInfo(AmapWeatherInfoRequest request) {
        String result = this.amapService.get(INFO,request.toJson());
        System.out.println(result);
        return null;
    }
}
