package club.mrxiao.amap.api.impl;

import club.mrxiao.amap.api.AmapDistrictService;
import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.bean.district.AmapDistrictRequest;
import club.mrxiao.amap.bean.district.AmapDistrictResult;
import club.mrxiao.common.error.AmapErrorException;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  行政区域查询
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-09
 */
@AllArgsConstructor
public class AmapDistrictServiceImpl implements AmapDistrictService {

    private final AmapService amapService;

    @Override
    public List<AmapDistrictResult> query(AmapDistrictRequest request) throws AmapErrorException {
        String result = this.amapService.get(DISTRICT,request.toJson());
        return AmapDistrictResult.toList(result);
    }
}
