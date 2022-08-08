package club.mrxiao.amap.bean.geocode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class AmapGeocodeReGeoRequest implements Serializable {

    private static final long serialVersionUID = 164055423987651136L;

    /**
     * 经纬度坐标
     * <pre>
     * 是否必填： 是
     * 描述：经纬度坐标;最多支持20个坐标点;多个点之间用"|"分割。
     *      传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位。
     * </pre>
     */
    private String location;

    /**
     * 返回附近POI类型
     * <pre>
     * 是否必填： 否
     * 描述：以下内容需要 extensions 参数为 all 时才生效。
     *      逆地理编码在进行坐标解析之后不仅可以返回地址描述，
     *      也可以返回经纬度附近符合限定要求的POI内容（在 extensions 字段值为 all 时才会返回POI内容）。
     *      设置 POI 类型参数相当于为上述操作限定要求。
     *      参数仅支持传入POI TYPECODE，可以传入多个POI TYPECODE，相互之间用“|”分隔。
     *      获取 POI TYPECODE 可以参考POI分类码表
     * </pre>
     */
    private String poitype;

    /**
     * 搜索半径
     * <pre>
     * 是否必填： 否
     * 缺省值：1000
     * 描述：radius取值范围在0~3000，默认是1000。单位：米
     * </pre>
     */
    private String radius;

    /**
     * 返回结果控制
     * <pre>
     * 是否必填： 否
     * 缺省值：base
     * 描述：extensions 参数默认取值是 base，也就是返回基本地址信息；
     *      extensions 参数取值为 all 时会返回基本地址信息、附近 POI 内容、道路信息以及道路交叉口信息。
     * </pre>
     */
    private String extensions;

    /**
     * 道路等级
     * <pre>
     * 是否必填： 否
     * 描述：以下内容需要 extensions 参数为 all 时才生效。
     *      可选值：0，1
     *      当roadlevel=0时，显示所有道路
     *      当roadlevel=1时，过滤非主干道路，仅输出主干道路数据
     * </pre>
     */
    private String roadlevel;

    /**
     * 批量查询控制
     * <pre>
     * 是否必填： 否
     * 描述：batch=true为批量查询。batch=false为单点查询
     * </pre>
     */
    private Boolean batch;

    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
