package club.mrxiao.amap.api;

import club.mrxiao.amap.bean.district.AmapDistrictRequest;
import club.mrxiao.amap.bean.district.AmapDistrictResult;
import club.mrxiao.common.error.AmapErrorException;

import java.util.List;

/**
 * <pre>
 *  行政区域查询
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-09
 */
public interface AmapDistrictService {

    /**
     * 行政区域查询API服务地址
     */
    String DISTRICT = "https://restapi.amap.com/v3/config/district";

    /**
     * 实况天气信息
     * @param request {@link AmapDistrictRequest}
     * @return {@link AmapDistrictResult}
     * @throws AmapErrorException 错误信息
     * <pre>
     *   <a href="https://lbs.amap.com/api/webservice/guide/api/weatherinfo">查看文档</a>
     * </pre>
     */
    List<AmapDistrictResult> query(AmapDistrictRequest request) throws AmapErrorException;
}
