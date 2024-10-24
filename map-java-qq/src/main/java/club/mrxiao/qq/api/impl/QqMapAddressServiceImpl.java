package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapAddressService;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.geocoder.QqMapGeocoderRequest;
import club.mrxiao.qq.bean.geocoder.QqMapGeocoderResult;
import lombok.AllArgsConstructor;

/**
 * <pre>
 *  腾讯地图地址服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@AllArgsConstructor
public class QqMapAddressServiceImpl implements QqMapAddressService {

    private final QqMapService qqMapService;

    @Override
    public QqMapGeocoderResult geocoder(QqMapGeocoderRequest request) throws QqMapErrorException {
        String result = this.qqMapService.get(GEOCODER,request.toJson());
        return QqMapGeocoderResult.fromJson(result);
    }
}
