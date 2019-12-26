package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapGeocoderService;
import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.bean.geocoder.BaiduMapGeocoderRequest;
import club.mrxiao.baidu.bean.geocoder.BaiduMapGeocoderResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import lombok.AllArgsConstructor;

/**
 * <pre>
 *  百度地图地理编码服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@AllArgsConstructor
public class BaiduMapGeocoderServiceImpl implements BaiduMapGeocoderService {

    private BaiduMapService baiduMapService;

    @Override
    public BaiduMapGeocoderResult geocoding(BaiduMapGeocoderRequest request) throws BaiduMapErrorException {
        String result = this.baiduMapService.get(GEOCODING,request.toJson());
        return BaiduMapGeocoderResult.fromJson(result);
    }
}
