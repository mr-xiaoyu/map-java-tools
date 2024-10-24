package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapPlaceService;
import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.bean.place.BaiduMapPlaceRequest;
import club.mrxiao.baidu.bean.place.BaiduMapPlaceResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  百度地图地点检索V2.0接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@AllArgsConstructor
public class BaiduMapPlaceServiceImpl implements BaiduMapPlaceService {

    private final BaiduMapService baiduMapService;

    @Override
    public <T> T placeSearch(BaiduMapPlaceRequest request) throws BaiduMapErrorException {
        String result = this.baiduMapService.get(PLACE_SEARCH,request.toJson());
        return BaiduMapPlaceResult.toList(result,"results");
    }

    @Override
    public List<BaiduMapPlaceResult> placeDetail(String scope, List<String> uids) throws BaiduMapErrorException {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("uids", StrUtil.join(",",uids));
        if(StrUtil.isNotBlank(scope)){
            jsonParam.put("scope",scope);
        }
        String result = this.baiduMapService.get(PLACE_DETAIL,jsonParam);
        return BaiduMapPlaceResult.toList(result,"result");
    }
}
