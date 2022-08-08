package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.test.ServiceFactory;
import club.mrxiao.amap.bean.weather.AmapWeatherForecastResult;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoRequest;
import club.mrxiao.amap.bean.weather.AmapWeatherLiveResult;
import club.mrxiao.common.error.AmapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class AmapWeatherServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void liveWeatherInfo() throws AmapErrorException {
        AmapService service = ServiceFactory.getAmapService();
        AmapWeatherInfoRequest request = AmapWeatherInfoRequest.builder()
                .city("110101")
                .build();
        List<AmapWeatherLiveResult> result = service.getAmapWeatherService().liveWeatherInfo(request);
        log.info("\n【result】:{}", JSON.toJSONString(result));
    }

    @Test
    public void forecastWeatherInfo() throws AmapErrorException {
        AmapService service = ServiceFactory.getAmapService();
        AmapWeatherInfoRequest request = AmapWeatherInfoRequest.builder()
                .city("110101")
                .build();
        List<AmapWeatherForecastResult> result = service.getAmapWeatherService().forecastWeatherInfo(request);
        log.info("\n【result】:{}", JSON.toJSONString(result));
    }
}