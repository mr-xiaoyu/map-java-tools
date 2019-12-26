package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.api.test.ServiceFactory;
import club.mrxiao.baidu.bean.geoconv.BaiduMapGeoconvRequest;
import club.mrxiao.baidu.bean.geoconv.BaiduMapGeoconvResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class BaiduMapGeoconvServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void geoconvTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        BaiduMapGeoconvRequest request = BaiduMapGeoconvRequest.builder()
                .coords("114.21892734521,29.575429778924;114.21892734521,29.575429778924;114.21892734521,29.575429778924")
                .from(1)
                .to(5)
                .build();
        List<BaiduMapGeoconvResult> results = service.getBaiduMapGeoconvService().geoconv(request);
        log.info("\n【result】:{}", JSON.toJSONString(results));
    }
}