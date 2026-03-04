package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapAddressService;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.address.*;
import com.alibaba.fastjson.JSONObject;
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

    @Override
    public QqMapAddressCompleteResult addressComplete(String address) throws QqMapErrorException {
        JSONObject param = new JSONObject();
        param.put("address",address);
        String result = this.qqMapService.get(ADDRESS_COMPLETE,param);
        return QqMapAddressCompleteResult.fromJson(result);
    }

    @Override
    public QqMapTruthAnalyResult truthAnaly(String address) throws QqMapErrorException {
        JSONObject param = new JSONObject();
        param.put("address",address);
        String result = this.qqMapService.get(TRUTH_ANALY,param);
        return QqMapTruthAnalyResult.fromJson(result);
    }

    @Override
    public QqMapAbnormalAnalyResult abnormalAnaly(String address) throws QqMapErrorException {
        JSONObject param = new JSONObject();
        param.put("address",address);
        String result = this.qqMapService.get(ABNORMAL_ANALY,param);
        return QqMapAbnormalAnalyResult.fromJson(result);
    }
}
