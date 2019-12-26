package club.mrxiao.baidu.api;

import club.mrxiao.baidu.bean.geocoder.BaiduMapGeocoderRequest;
import club.mrxiao.baidu.bean.geocoder.BaiduMapGeocoderResult;
import club.mrxiao.common.error.BaiduMapErrorException;

/**
 * <pre>
 *  百度地图地理编码服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
public interface BaiduMapGeocoderService {

    String GEOCODING = "https://api.map.baidu.com/geocoding/v3/";

    /**
     *  地理编码服务
     * @param request  百度地图地理编码服务请求对象
     * @return 百度地图地理编码服务响应对象
     * @throws BaiduMapErrorException 错误信息
     * <pre>
     *   <a href="http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding">查看文档</a>
     * </pre>
     */
    BaiduMapGeocoderResult geocoding(BaiduMapGeocoderRequest request) throws BaiduMapErrorException;
}
