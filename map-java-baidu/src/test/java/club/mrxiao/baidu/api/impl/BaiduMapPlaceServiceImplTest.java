package club.mrxiao.baidu.api.impl;


import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.api.test.ServiceFactory;
import club.mrxiao.baidu.bean.place.BaiduMapPlaceRequest;
import club.mrxiao.baidu.bean.place.BaiduMapPlaceResult;
import club.mrxiao.common.bran.ResultDataTable;
import club.mrxiao.common.error.BaiduMapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BaiduMapPlaceServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void placeSearchTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        BaiduMapPlaceRequest request = BaiduMapPlaceRequest.builder()
                .query("和泰园")
                .region("北京")
                .build();
        List<BaiduMapPlaceResult> results = service.getBaiduMapPlaceService().placeSearch(request);
        log.info("\n【result】:{}", JSON.toJSONString(results));
    }

    @Test
    public void placeSearchPageTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        BaiduMapPlaceRequest request = BaiduMapPlaceRequest.builder()
                .query("和泰园")
                .region("北京")
                .pageNum(0)
                .pageSize(2)
                .build();
        ResultDataTable table = service.getBaiduMapPlaceService().placeSearch(request);
        log.info("\n【result】:{}", JSON.toJSONString(table));
    }

    @Test
    public void placeDetailTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        List<String> uids = new ArrayList<>();
        uids.add("a1418eb477b2897feae5828d");
        uids.add("0bb0c4527e9adc93da2f2863");
        uids.add("59a72490fd34fc879cec2bae");
        List<BaiduMapPlaceResult> results = service.getBaiduMapPlaceService().placeDetail(null,uids);
        log.info("\n【result】:{}", JSON.toJSONString(results));
    }

}
