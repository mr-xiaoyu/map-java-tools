package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.test.ServiceFactory;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoResult;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class AmapGeocodeServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void geocodeGeo() {
        AmapService service = ServiceFactory.getAmapService();
        AmapGeocodeGeoRequest request = AmapGeocodeGeoRequest.builder()
                .address("西坝河北里25号楼")
                .build();
        AmapGeocodeGeoResult result = service.getAmapGeocodeService().geocodeGeo(request);
        log.info("\n【result】:{}", JSON.toJSONString(result));
    }
}