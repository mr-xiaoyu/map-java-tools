package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.test.ServiceFactory;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoResult;
import club.mrxiao.amap.bean.geocode.AmapGeocodeReGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeReGeoResult;
import club.mrxiao.common.error.AmapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class AmapGeocodeServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void geocodeGeo() throws AmapErrorException {
        AmapService service = ServiceFactory.getAmapService();
        AmapGeocodeGeoRequest request = AmapGeocodeGeoRequest.builder()
                .city("北京市")
                .address("西坝河北里25号楼和泰园C-102")
                .build();
        List<AmapGeocodeGeoResult> result = service.getAmapGeocodeService().geocodeGeo(request);
        log.info("\n【result】: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void geocodeReGeo() throws AmapErrorException {
        AmapService service = ServiceFactory.getAmapService();
        AmapGeocodeReGeoRequest request = AmapGeocodeReGeoRequest.builder()
                .location("114.219131,39.435103")
                .extensions("all")
                .build();
        AmapGeocodeReGeoResult result = service.getAmapGeocodeService().geocodeReGeo(request);
        log.info("\n【result】: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void batchGeocodeReGeo() throws AmapErrorException {
        AmapService service = ServiceFactory.getAmapService();
        AmapGeocodeReGeoRequest request = AmapGeocodeReGeoRequest.builder()
                .location("116.441807,39.972018|116.453003,39.895781")
                .extensions("all")
                .build();
        List<AmapGeocodeReGeoResult> result = service.getAmapGeocodeService().batchGeocodeReGeo(request);
        log.info("\n【result】: \n{}", JSON.toJSONString(result));
    }
}