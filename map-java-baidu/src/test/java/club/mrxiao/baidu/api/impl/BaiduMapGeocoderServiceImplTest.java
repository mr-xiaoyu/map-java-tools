package club.mrxiao.baidu.api.impl;


import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.api.test.ServiceFactory;
import club.mrxiao.baidu.bean.geocoder.BaiduMapGeocoderRequest;
import club.mrxiao.baidu.bean.geocoder.BaiduMapGeocoderResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class BaiduMapGeocoderServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void geocodingTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        BaiduMapGeocoderRequest request = BaiduMapGeocoderRequest.builder()
                .address("北京市朝阳区西坝河北里202号院")
                .city("北京市")
                .build();
        BaiduMapGeocoderResult result = service.getBaiduMapGeocoderService().geocoding(request);
        log.info("\n【result】:{}", JSON.toJSONString(result));
    }
}
