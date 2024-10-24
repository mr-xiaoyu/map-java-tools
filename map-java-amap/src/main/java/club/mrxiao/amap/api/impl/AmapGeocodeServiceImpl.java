package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapGeocodeService;
import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoResult;
import club.mrxiao.amap.bean.geocode.AmapGeocodeReGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeReGeoResult;
import club.mrxiao.common.error.AmapErrorException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  地理编码服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
@AllArgsConstructor
public class AmapGeocodeServiceImpl implements AmapGeocodeService {

    private final AmapService amapService;

    @Override
    public List<AmapGeocodeGeoResult> geocodeGeo(AmapGeocodeGeoRequest amapGeocodeGeoRequest) throws AmapErrorException {
        String result = this.amapService.get(GEO,amapGeocodeGeoRequest.toJson());
        return AmapGeocodeGeoResult.toList(result);
    }

    @Override
    public AmapGeocodeReGeoResult geocodeReGeo(AmapGeocodeReGeoRequest amapGeocodeReGeoRequest) throws AmapErrorException {
        String result = this.amapService.get(RE_GEO,amapGeocodeReGeoRequest.toJson());
        return AmapGeocodeReGeoResult.fromJson(result);
    }

    @Override
    public List<AmapGeocodeReGeoResult> batchGeocodeReGeo(AmapGeocodeReGeoRequest amapGeocodeReGeoRequest) throws AmapErrorException {
        amapGeocodeReGeoRequest.setBatch(true);
        String result = this.amapService.get(RE_GEO,amapGeocodeReGeoRequest.toJson());
        return AmapGeocodeReGeoResult.toList(result);
    }
}
