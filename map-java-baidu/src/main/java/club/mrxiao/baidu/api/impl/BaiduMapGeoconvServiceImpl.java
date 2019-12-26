package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapGeoconvService;
import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.bean.geoconv.BaiduMapGeoconvRequest;
import club.mrxiao.baidu.bean.geoconv.BaiduMapGeoconvResult;
import club.mrxiao.common.error.BaiduMapErrorException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  百度地图坐标转换服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@AllArgsConstructor
public class BaiduMapGeoconvServiceImpl implements BaiduMapGeoconvService {

    private BaiduMapService baiduMapService;


    @Override
    public List<BaiduMapGeoconvResult> geoconv(BaiduMapGeoconvRequest request) throws BaiduMapErrorException {
        String result = this.baiduMapService.get(GEOCONV,request.toJson());
        return BaiduMapGeoconvResult.toList(result);
    }
}
