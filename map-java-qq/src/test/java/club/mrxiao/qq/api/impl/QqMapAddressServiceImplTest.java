package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.geocoder.QqMapGeocoderRequest;
import club.mrxiao.qq.bean.geocoder.QqMapGeocoderResult;
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
                .address("北京市朝阳区西坝河北里25号楼和泰园C-102")
//                .location("39.972359,116.442037")
                .build();
        QqMapGeocoderResult result = service.getQqMapAddressService().geocoder(request);
        log.info("result: \n{}", JSON.toJSONString(result));
    }
}