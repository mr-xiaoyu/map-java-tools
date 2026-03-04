package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.address.*;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import test.ServiceFactory;

public class QqMapAddressServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void geocoderTest() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapGeocoderRequest request = QqMapGeocoderRequest.builder()
                .address("北京市西城区新街口街道西直门内大街188号楼307")
//                .location("39.972359,116.442037")
                .build();
        QqMapGeocoderResult result = service.getQqMapAddressService().geocoder(request);
        log.info("result: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void addressComplete() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapAddressCompleteResult result = service.getQqMapAddressService().addressComplete("北京市西城区西直门内大街188号楼307");
        log.info("result: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void truthAnaly() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapTruthAnalyResult result = service.getQqMapAddressService().truthAnaly("北京市西城区西直门内大街188号楼307");
        log.info("result: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void abnormalAnaly() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapAbnormalAnalyResult result = service.getQqMapAddressService().abnormalAnaly("北京市西城区西直门内大街188号楼307");
        log.info("result: \n{}", JSON.toJSONString(result));
    }

}