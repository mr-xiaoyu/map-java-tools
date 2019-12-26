package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.api.test.ServiceFactory;
import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionRequest;
import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;


public class BaiduMapPlaceSuggestionServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void suggestionTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        BaiduMapPlaceSuggestionRequest request = BaiduMapPlaceSuggestionRequest.builder()
                .query("西坝河北里202号").region("北京市").build();
        List<BaiduMapPlaceSuggestionResult> results = service.getBaiduMapPlaceSuggestionService().suggestion(request);
        log.info("\n【result】:{}", JSON.toJSONString(results));
    }

    @Test
    public void abroadSuggestionTest() throws BaiduMapErrorException {
        BaiduMapService service = ServiceFactory.getService();
        BaiduMapPlaceSuggestionRequest request = BaiduMapPlaceSuggestionRequest.builder()
                .query("东京").region("东京").build();
        List<BaiduMapPlaceSuggestionResult> results = service.getBaiduMapPlaceSuggestionService().abroadSuggestion(request);
        log.info("\n【result】:{}", JSON.toJSONString(results));
    }
}
