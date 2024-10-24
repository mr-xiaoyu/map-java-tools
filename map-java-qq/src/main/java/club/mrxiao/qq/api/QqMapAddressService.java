package club.mrxiao.qq.api;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.bean.geocoder.QqMapGeocoderRequest;
import club.mrxiao.qq.bean.geocoder.QqMapGeocoderResult;

/**
 * <pre>
 *  腾讯地图地址服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
public interface QqMapAddressService {

    String GEOCODER = "https://apis.map.qq.com/ws/geocoder/v1";

    /**
     * 地址解析
     * @param request {@link QqMapGeocoderRequest}
     * @return 解析结果
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/Gcoder">逆地址解析</a>
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/Geocoder">地址解析</a>
     */
    QqMapGeocoderResult geocoder(QqMapGeocoderRequest request) throws QqMapErrorException;;
}
