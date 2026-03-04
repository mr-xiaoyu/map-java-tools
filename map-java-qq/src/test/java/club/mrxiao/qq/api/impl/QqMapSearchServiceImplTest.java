package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.search.QqMapDistrictRequest;
import club.mrxiao.qq.bean.search.QqMapDistrictResult;
import club.mrxiao.qq.bean.search.QqMapPlaceRequest;
import club.mrxiao.qq.bean.search.QqMapPlaceResult;
import club.mrxiao.qq.bean.search.QqMapSuggestionRequest;
import club.mrxiao.qq.bean.search.QqMapSuggestionResult;
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
                .id("500000")
                .build();
        QqMapDistrictResult result = service.getQqMapSearchService().districtGetChildren(request);
        log.info("result: \n{}", JSON.toJSONString(result));
    }

    @Test
    public void suggestion() throws QqMapErrorException {
        QqMapService service = ServiceFactory.getService();
        QqMapSuggestionRequest request = QqMapSuggestionRequest.builder()
                .keyword("和泰园C")
                .addressFormat("short")
                .build();
        QqMapSuggestionResult result = service.getQqMapSearchService().suggestion(request);
        log.info("result: \n{}", JSON.toJSONString(result));
    }
}