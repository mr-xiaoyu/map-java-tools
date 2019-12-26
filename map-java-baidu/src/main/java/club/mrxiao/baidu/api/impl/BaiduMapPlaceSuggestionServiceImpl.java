package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapPlaceSuggestionService;
import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionRequest;
import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  百度地图地点输入提示服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
@AllArgsConstructor
public class BaiduMapPlaceSuggestionServiceImpl implements BaiduMapPlaceSuggestionService {

    private BaiduMapService baiduMapService;

    @Override
    public List<BaiduMapPlaceSuggestionResult> suggestion(BaiduMapPlaceSuggestionRequest request) throws BaiduMapErrorException {
        String result = this.baiduMapService.get(SUGGESTION,request.toJson());
        return BaiduMapPlaceSuggestionResult.toList(result);
    }

    @Override
    public List<BaiduMapPlaceSuggestionResult> abroadSuggestion(BaiduMapPlaceSuggestionRequest request) throws BaiduMapErrorException {
        String result = this.baiduMapService.get(SUGGESTION_ABROAD,request.toJson());
        return BaiduMapPlaceSuggestionResult.toList(result);
    }
}
