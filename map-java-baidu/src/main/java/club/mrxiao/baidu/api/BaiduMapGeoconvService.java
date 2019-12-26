package club.mrxiao.baidu.api;

import club.mrxiao.baidu.bean.geoconv.BaiduMapGeoconvRequest;
import club.mrxiao.baidu.bean.geoconv.BaiduMapGeoconvResult;
import club.mrxiao.common.error.BaiduMapErrorException;

import java.util.List;

/**
 * <pre>
 *  百度地图坐标转换服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
public interface BaiduMapGeoconvService {

    /**
     * 坐标转换
     */
    String GEOCONV = "http://api.map.baidu.com/geoconv/v1/";


    /**
     * 坐标转换
     * @param request 百度地图坐标转换服务请求对象
     * @return 百度地图坐标转换服务响应对象集合
     * @throws BaiduMapErrorException 错误信息
     */
    List<BaiduMapGeoconvResult> geoconv(BaiduMapGeoconvRequest request) throws BaiduMapErrorException;
}
