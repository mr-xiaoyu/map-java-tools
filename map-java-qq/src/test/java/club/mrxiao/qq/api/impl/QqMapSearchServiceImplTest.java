package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.district.QqMapDistrictRequest;
import club.mrxiao.qq.bean.district.QqMapDistrictResult;
import club.mrxiao.qq.bean.place.QqMapPlaceRequest;
import club.mrxiao.qq.bean.place.QqMapPlaceResult;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import test.ServiceFactory;

public class QqMapSearchServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void placeSearchTest() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapPlaceRequest request = QqMapPlaceRequest.builder()
                .keyword("公园")
                .boundary("region(北京市)")
                .getSubpois("1")
                .build();
        QqMapPlaceResult result = service.getQqMapSearchService().placeSearch(request);
        log.info("result: \n{}", JSON.toJSONString(result));
    }


    @Test
    public void districtList() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapDistrictResult result = service.getQqMapSearchService().districtList();
        log.info("result: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void districtTree() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapDistrictResult result = service.getQqMapSearchService().districtTree();
        log.info("result: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void districtGetChildren() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapDistrictRequest request = QqMapDistrictRequest.builder()
                .id("469021")
                .build();
        QqMapDistrictResult result = service.getQqMapSearchService().districtGetChildren(request);
        log.info("result: \n{}", JSON.toJSONString(result));
    }
}