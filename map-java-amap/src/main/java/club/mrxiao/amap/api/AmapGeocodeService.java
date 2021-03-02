package club.mrxiao.amap.api;

import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoResult;

/**
 * <pre>
 *  地理/逆地理编码服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
public interface AmapGeocodeService{

    /**
     * 地理编码 API 服务地址
     */
    String GEO = "https://restapi.amap.com/v3/geocode/geo";

    /**
     * 逆地理编码API服务地址
     */
    String REGEO = "https://restapi.amap.com/v3/geocode/regeo";


    /**
     * 地理编码
     * @param amapGeocodeGeoRequest {@link AmapGeocodeGeoRequest}
     * @return {@link AmapGeocodeGeoResult}
     */
    AmapGeocodeGeoResult geocodeGeo(AmapGeocodeGeoRequest amapGeocodeGeoRequest);
}
