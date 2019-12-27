package club.mrxiao.baidu.bean.place;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      百度地图地点检索服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
@Builder
public class BaiduMapPlaceRequest implements Serializable {

    private static final long serialVersionUID = 1999956376236519008L;

    /**
     * 检索关键字
     * <pre>
     * 是否必填： 是
     * 描述： 行政区划区域检索不支持多关键字检索。如果需要按POI分类进行检索，请将分类通过query参数进行设置，如query=美食	string(45)	天安门、美食
     * </pre>
     */
    private String query;

    /**
     * 检索分类偏好
     * <pre>
     * 是否必填： 否
     * 描述： 检索分类偏好，与q组合进行检索，多个分类以","分隔，（POI分类），如果需要严格按分类检索，请通过query参数设置
     * </pre>
     */
    private String tag;

    //************行政区划区域检索 start************/

    /**
     * 检索行政区划区域
     * <pre>
     * 是否必填： 是
     * 描述： 可输入行政区划名或对应cityCode	string(50)	北京、131（北京的code）、海淀区、全国，等
     * </pre>
     */
    private String region;

    /**
     * 区域数据召回限制
     * <pre>
     * 是否必填： 否
     * 描述： 为true时，仅召回region对应区域内数据
     * </pre>
     */
    @JSONField(name="city_limit")
    private Boolean cityLimit;

    //************行政区划区域检索 end************/

    //************圆形区域检索 start************/

    /**
     * 圆形区域检索中心点，不支持多个点
     * <pre>
     * 是否必填： 是
     * 描述： lat(纬度),lng(经度)
     * </pre>
     */
    private String location;

    /**
     * 圆形区域检索半径，单位为米。
     * <pre>
     * 是否必填： 否
     * 描述： 当半径过大，超过中心点所在城市边界时，会变为城市范围检索，检索范围为中心点所在城市;默认1000
     * </pre>
     */
    private String radius;

    /**
     * 是否严格限定召回结果在设置检索半径范围内
     * <pre>
     * 是否必填： 否
     * 描述： 设置为true时会影响返回结果中total准确性及每页召回poi数量，我们会逐步解决此类问题。
     * </pre>
     */
    @JSONField(name="radius_limit")
    private Boolean radiusLimit;

    //************圆形区域检索 end************/

    //************矩形区域检索 start************/
    /**
     * 检索矩形区域，多组坐标间以","分隔
     * <pre>
     * 是否必填： 是
     * 描述： 38.76623,116.43213,39.54321,116.46773 lat,lng(左下角坐标),lat,lng(右上角坐标
     * </pre>
     */
    private String bounds;
    //************矩形区域检索 end************/

    /**
     * 检索结果详细程度
     * <pre>
     * 是否必填： 否
     * 描述： 取值为1 或空，则返回基本信息；取值为2，返回检索POI详细信息
     * </pre>
     */
    private String scope;

    /**
     * 检索过滤条件,当scope取值为2时，可以设置filter进行排序。
     * <pre>
     * 是否必填： 否
     * 描述：
     * industry_type：行业类型，注意：设置该字段可提高检索速度和过滤精度，取值有： hotel（宾馆）；cater（餐饮）；life（生活娱乐） sort_name：排序字段，根据industry_type字段的值而定。 1、industry_type为hotel时，sort_name取值有： default（默认）；price（价格）；total_score（好评）；level（星级）；health_score（卫生）；distance（距离排序，只有圆形区域检索有效） 2、industry_type为cater时，sort_name取值有： default（默认）；taste_rating（口味）；price（价格）；overall_rating（好评）；service_rating（服务）；distance（距离排序，只有圆形区域检索有效） 3、industry_type为life时，sort_name取值有： default（默认）；price（价格）；overall_rating（好评）；comment_num（服务）；distance（距离排序，只有圆形区域检索有效）
     * sort_rule：排序规则：0（从高到低），1（从低到高）
     * price_section：价格区间
     * groupon：是否有团购：1（有），0（无）
     * discount：是否有打折：1（有），0（无）
     * </pre>
     */
    private String filter;

    /**
     * 坐标类型
     * <pre>
     * 是否必填： 否
     * 描述： 1（wgs84ll即GPS经纬度），2（gcj02ll即国测局经纬度坐标），3（bd09ll即百度经纬度坐标），4（bd09mc即百度米制坐标）注："ll为小写LL"
     * </pre>
     */
    @JSONField(name="coord_type")
    private Integer coordType;

    /**
     * 返回坐标类型
     * <pre>
     * 是否必填： 否
     * 描述： 添加后POI返回国测局经纬度坐标
     * </pre>
     */
    @JSONField(name="ret_coordtype")
    private String retCoordtype;


    /**
     * 单次召回POI数量
     * <pre>
     * 是否必填： 否
     * 描述： 默认为10条记录，最大返回20条。多关键字检索时，返回的记录数为关键字个数
     * </pre>
     */
    @JSONField(name="page_size")
    private Integer pageSize;

    /**
     * 分页页码
     * <pre>
     * 是否必填： 否
     * 描述： 默认为0,0代表第一页，1代表第二页，以此类推。
     * </pre>
     */
    @JSONField(name="page_num")
    private Integer pageNum;


    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
