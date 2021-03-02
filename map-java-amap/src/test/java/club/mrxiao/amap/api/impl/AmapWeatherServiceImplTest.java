package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.test.ServiceFactory;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoRequest;
import club.mrxiao.amap.bean.weather.AmapWeatherInfoResult;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class AmapWeatherServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void weatherInfo() {
        AmapService service = ServiceFactory.getAmapService();

        AmapWeatherInfoRequest request = AmapWeatherInfoRequest.builder()
                .city("110101")
                .extensions("all")
                .build();

        AmapWeatherInfoResult result = service.getAmapWeatherService().weatherInfo(request);
        log.info("\n【result】:{}", JSON.toJSONString(result));
    }
}