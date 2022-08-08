package club.mrxiao.amap.api;

import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoResult;
import club.mrxiao.amap.bean.geocode.AmapGeocodeReGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeReGeoResult;
import club.mrxiao.common.error.AmapErrorException;

import java.util.List;

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
    String RE_GEO = "https://restapi.amap.com/v3/geocode/regeo";


    /**
     * 地理编码
     * @param amapGeocodeGeoRequest {@link AmapGeocodeGeoRequest}
     * @return {@link AmapGeocodeGeoResult}
     * @throws AmapErrorException 错误信息
     */
    List<AmapGeocodeGeoResult> geocodeGeo(AmapGeocodeGeoRequest amapGeocodeGeoRequest) throws AmapErrorException;

    /**
     * 逆地理编码
     * @param amapGeocodeReGeoRequest {@link AmapGeocodeReGeoRequest}
     * @return {@link AmapGeocodeReGeoResult}
     * @throws AmapErrorException 错误信息
     */
    AmapGeocodeReGeoResult geocodeReGeo(AmapGeocodeReGeoRequest amapGeocodeReGeoRequest) throws AmapErrorException;

    /**
     * 批量逆地理编码
     * @param amapGeocodeReGeoRequest {@link AmapGeocodeReGeoRequest}
     * @return {@link AmapGeocodeReGeoResult}
     * @throws AmapErrorException 错误信息
     */
    List<AmapGeocodeReGeoResult> batchGeocodeReGeo(AmapGeocodeReGeoRequest amapGeocodeReGeoRequest) throws AmapErrorException;
}
