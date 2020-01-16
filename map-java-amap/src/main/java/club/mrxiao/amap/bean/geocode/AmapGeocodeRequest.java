package club.mrxiao.amap.bean.geocode;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 地理/逆地理编码服务请求对象
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-27
 */
@Data
@Builder
public class AmapGeocodeRequest implements Serializable {

    private static final long serialVersionUID = 6256850090831595132L;

    /**
     * 结构化地址信息
     * <pre>
     * 是否必填： 是
     * </pre>
     */
    private String address;

    /**
     * 指定查询的城市
     * <pre>
     * 是否必填： 否
     * 描述：无，会进行全国范围内搜索
     * </pre>
     */
    private String city;

    /**
     * 批量查询控制
     * <pre>
     * 是否必填： 否
     * 描述：
     *  batch 参数设置为 true 时进行批量查询操作，最多支持 10 个地址进行批量查询。
     *  batch 参数设置为 false 时进行单点查询，此时即使传入多个地址也只返回第一个地址的解析查询结果。
     *  默认false
     * </pre>
     */
    private Boolean batch;
}
