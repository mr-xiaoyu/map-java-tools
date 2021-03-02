package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapGeocodeService;
import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoRequest;
import club.mrxiao.amap.bean.geocode.AmapGeocodeGeoResult;
import lombok.AllArgsConstructor;

/**
 * <pre>
 *  地理编码服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
@AllArgsConstructor
public class AmapGeocodeServiceImpl implements AmapGeocodeService {

    private AmapService amapService;

    @Override
    public AmapGeocodeGeoResult geocodeGeo(AmapGeocodeGeoRequest amapGeocodeGeoRequest) {

        String result = this.amapService.get(GEO,amapGeocodeGeoRequest.toJson());
        System.out.println(result);
        return null;
    }
}
