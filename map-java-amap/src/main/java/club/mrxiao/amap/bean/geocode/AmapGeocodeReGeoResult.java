package club.mrxiao.amap.bean.geocode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 地理/逆地理编码服务响应对象
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-08
 */
@Data
public class AmapGeocodeReGeoResult implements Serializable {

    private static final long serialVersionUID = -5827198808610569150L;

    /**
     * 地址元素列表
     */
    private AddressComponent addressComponent;

    /**
     * 道路信息列表
     * <pre>
     *     请求参数 extensions 为 all 时返回如下内容
     * </pre>
     */
    private List<Road> roads;

    /**
     * 道路交叉口列表
     * <pre>
     *     请求参数 extensions 为 all 时返回如下内容
     * </pre>
     */
    private List<Roadinter> roadinters;

    /**
     * poi信息列表
     * <pre>
     *     请求参数 extensions 为 all 时返回如下内容
     * </pre>
     */
    private List<Poi> pois;

    /**
     * aoi信息列表
     * <pre>
     *     请求参数 extensions 为 all 时返回如下内容
     * </pre>
     */
    private List<Aoi> aois;


    /**
     * 地址元素列表
     */
    @Data
    public static class AddressComponent{

        /**
         * 坐标点所在省名称
         * <pre>
         *     例如：北京市
         * </pre>
         */
        private String province;

        /**
         * 坐标点所在城市名称
         * <pre>
         *     请注意：当城市是省直辖县时返回为空，以及城市为北京、上海、天津、重庆四个直辖市时，该字段返回为空；
         * </pre>
         */
        private String city;

        /**
         * 城市编码
         */
        private String citycode;

        /**
         * 坐标点所在区
         * <pre>
         *     例如：海淀区
         * </pre>
         */
        private String district;

        /**
         * 行政区编码
         * <pre>
         *     例如：110108
         * </pre>
         */
        private String adcode;

        /**
         * 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息）
         * <pre>
         *     例如：燕园街道
         * </pre>
         */
        private String township;

        /**
         * 乡镇街道编码
         * <pre>
         *     例如：110101001000
         * </pre>
         */
        private String towncode;

        /**
         * 社区信息列表
         */
        private Neighborhood neighborhood;

        /**
         * 楼信息列表
         */
        private Building building;

        /**
         * 门牌信息列表
         */
        private StreetNumber streetNumber;
    }

    /**
     * 社区信息列表
     */
    @Data
    public static class Neighborhood{

        /**
         * 社区名称
         * <pre>
         *     例如：北京大学
         * </pre>
         */
        private String name;

        /**
         * POI类型
         * <pre>
         *     例如：科教文化服务;学校;高等院校
         * </pre>
         */
        private String type;
    }

    /**
     * 楼信息列表
     */
    @Data
    public static class Building{

        /**
         * 建筑名称
         * <pre>
         *     例如：万达广场
         * </pre>
         */
        private String name;

        /**
         * 类型
         * <pre>
         *     例如：科教文化服务;学校;高等院校
         * </pre>
         */
        private String type;
    }

    /**
     * 门牌信息列表
     */
    @Data
    public static class StreetNumber{

        /**
         * 街道名称
         * <pre>
         *     例如：中关村北二条
         * </pre>
         */
        private String street;

        /**
         * 门牌号
         * <pre>
         *     例如：3号
         * </pre>
         */
        private String number;

        /**
         * 坐标点
         * <pre>
         *     经纬度坐标点：经度，纬度
         * </pre>
         */
        private String location;

        /**
         * 方向
         * <pre>
         *     坐标点所处街道方位
         * </pre>
         */
        private String direction;

        /**
         * 门牌地址到请求坐标的距离
         * <pre>
         *     单位：米
         * </pre>
         */
        private String distance;
    }

    /**
     * 道路信息
     */
    @Data
    public static class Road {

        /**
         * 道路id
         */
        private String id;

        /**
         * 道路名称
         */
        private String name;

        /**
         * 道路到请求坐标的距离
         * <pre>
         *     单位：米
         * </pre>
         */
        private String distance;

        /**
         * 方位
         * <pre>
         *     输入点和此路的相对方位
         * </pre>
         */
        private String direction;

        /**
         * 坐标点
         */
        private String location;
    }

    /**
     * 道路交叉口
     */
    @Data
    public static class Roadinter {

        /**
         * 交叉路口到请求坐标的距离
         * <pre>
         *     单位：米
         * </pre>
         */
        private String distance;

        /**
         * 方位
         * <pre>
         *     输入点和此路的相对方位
         * </pre>
         */
        private String direction;

        /**
         * 路口经纬度
         */
        private String location;

        /**
         * 第一条道路id
         */
        @JSONField(name="first_id")
        private String firstId;

        /**
         * 第一条道路名称
         */
        @JSONField(name="first_name")
        private String firstName;

        /**
         * 第二条道路id
         */
        @JSONField(name="second_id")
        private String secondId;

        /**
         * 第二条道路名称
         */
        @JSONField(name="second_name")
        private String secondName;
    }

    /**
     * poi 信息
     */
    @Data
    public static class Poi {

        /**
         * poi的id
         */
        private String id;

        /**
         * poi点名称
         */
        private String name;

        /**
         * poi类型
         */
        private String type;

        /**
         * 电话
         */
        private String tel;

        /**
         * 该POI的中心点到请求坐标的距离
         * <pre>
         *     单位：米
         * </pre>
         */
        private String distance;

        /**
         * 方位
         * <pre>
         *     为输入点相对建筑物的方位
         * </pre>
         */
        private String direction;

        /**
         * poi地址信息
         */
        private String address;

        /**
         * 坐标点
         */
        private String location;

        /**
         * poi所在商圈名称
         */
        private String businessarea;
    }

    /**
     * aoi信息
     */
    @Data
    public static class Aoi {

        /**
         * 所属 aoi的id
         */
        private String id;

        /**
         * 所属 aoi 名称
         */
        private String name;

        /**
         * 所属 aoi 所在区域编码
         */
        private String adcode;

        /**
         * 所属 aoi 中心点坐标
         */
        private String location;

        /**
         * 所属aoi点面积
         * <pre>
         *     单位：平方米
         * </pre>
         */
        private String area;

        /**
         * 输入经纬度是否在aoi面之中
         * <pre>
         *     0，代表在aoi内;其余整数代表距离AOI的距离
         * </pre>
         */
        private String distance;

        /**
         * 所属 aoi 类型
         */
        private String type;
    }


    public static List<AmapGeocodeReGeoResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("regeocodes").toJavaList(AmapGeocodeReGeoResult.class);
    }

    public static AmapGeocodeReGeoResult fromJson(String json){
        return JSONObject.parseObject(json).getJSONObject("regeocode").toJavaObject(AmapGeocodeReGeoResult.class);
    }
}
