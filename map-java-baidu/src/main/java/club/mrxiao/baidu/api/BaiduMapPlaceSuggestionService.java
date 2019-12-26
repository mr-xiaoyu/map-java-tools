package club.mrxiao.baidu.api;

import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionRequest;
import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionResult;
import club.mrxiao.common.error.BaiduMapErrorException;

import java.util.List;

/**
 * <pre>
 *  百度地图地点输入提示服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
public interface BaiduMapPlaceSuggestionService {

    /**
     * 地点输入提示V2.0
     */
    String SUGGESTION = "http://api.map.baidu.com/place/v2/suggestion";

    /**
     * 地点输入提示V2.0
     * @param request  百度地图地点输入提示服务请求对象
     * @return 检索结果
     * @throws BaiduMapErrorException 错误信息
     * <pre>
     *   <a href="http://lbsyun.baidu.com/index.php?title=webapi/place-suggestion-api">查看文档</a>
     * </pre>
     */
    List<BaiduMapPlaceSuggestionResult> suggestion(BaiduMapPlaceSuggestionRequest request) throws BaiduMapErrorException;
}
