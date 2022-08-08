package club.mrxiao.amap.bean.geocode;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 地理/逆地理编码服务响应对象
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-27
 */
@Data
public class AmapGeocodeGeoResult implements Serializable {

    private static final long serialVersionUID = -5872252292442519223L;

    /**
     * 国家
     * <pre>
     *     国内地址默认返回中国
     * </pre>
     */
    private String country;

    /**
     * 地址所在的省份名
     * <pre>
     *     例如：北京市。此处需要注意的是，中国的四大直辖市也算作省级单位。
     * </pre>
     */
    private String province;

    /**
     * 地址所在的城市名
     * <pre>
     *     例如：北京市
     * </pre>
     */
    private String city;

    /**
     * 城市编码
     */
    private String citycode;

    /**
     * 地址所在的区
     * <pre>
     *     例如：朝阳区
     * </pre>
     */
    private String district;

    /**
     * 街道
     * <pre>
     *     例如：阜通东大街
     * </pre>
     */
    private String street;

    /**
     * 门牌
     * <pre>
     *     例如：6号
     * </pre>
     */
    private String number;

    /**
     * 区域编码
     * <pre>
     *     例如：110101
     * </pre>
     */
    private String adcode;

    /**
     * 坐标点
     * <pre>
     *     经度，纬度
     * </pre>
     */
    private String location;

    /**
     * 匹配级别
     * <pre>
     *     经度，纬度
     * </pre>
     */
    private String level;


    public static List<AmapGeocodeGeoResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("geocodes").toJavaList(AmapGeocodeGeoResult.class);
    }

}
