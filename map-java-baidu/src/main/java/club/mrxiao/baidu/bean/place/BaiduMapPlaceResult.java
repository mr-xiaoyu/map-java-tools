package club.mrxiao.baidu.bean.place;

import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionResult;
import club.mrxiao.common.bran.ResultDataTable;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *      百度地图地点检索服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
public class BaiduMapPlaceResult implements Serializable {

    private static final long serialVersionUID = -296332727600629523L;

    /**
     * poi名称
     */
    private String name;

    /**
     * poi地址信息
     */
    private String address;

    /**
     * 所属省份
     */
    private String province;

    /**
     * 所属城市
     */
    private String city;

    /**
     * 所属区县
     */
    private String area;

    /**
     * poi电话信息
     */
    private String telephone;

    /**
     * poi的唯一标示，可用于详情检索
     */
    private String uid;

    /**
     * 街景图id
     */
    @JSONField(name="street_id")
    private String streetId;

    /**
     * 是否有详情页：1有，0没有
     */
    private String detail;

    /**
     * poi经纬度坐标
     */
    private BaiduMapPlaceSuggestionResult.Location location;

    /**
     * poi的扩展信息，仅当scope=2时，显示该字段，不同的poi类型，显示的detail_info字段不同。
     */
    @JSONField(name="detail_info")
    private DetailInfo detailInfo;



    /**
     * poi的扩展信息
     */
    @Data
    private static class DetailInfo{

        /**
         * 距离中心点的距离，圆形区域检索时返回
         */
        private int distance;

        /**
         * 所属分类，如’hotel’、’cater’。
         */
        private String type;

        /**
         * 标签
         */
        private String tag;

        /**
         * poi别名
         */
        private String alias;

        /**
         * poi的详情页
         */
        @JSONField(name="detail_url")
        private String detailUrl;

        /**
         * poi商户的价格
         */
        private String price;

        /**
         * 营业时间
         */
        @JSONField(name="shop_hours")
        private String shopHours;

        /**
         * 总体评分
         */
        @JSONField(name="overall_rating")
        private String overallRating;

        /**
         * 口味评分
         */
        @JSONField(name="taste_rating")
        private String tasteRating;

        /**
         * 服务评分
         */
        @JSONField(name="service_rating")
        private String serviceRating;

        /**
         * 环境评分
         */
        @JSONField(name="environment_rating")
        private String environmentRating;

        /**
         * 星级（设备）评分
         */
        @JSONField(name="facility_rating")
        private String facilityRating;

        /**
         * 卫生评分
         */
        @JSONField(name="hygiene_rating")
        private String hygieneRating;

        /**
         * 技术评分
         */
        @JSONField(name="technology_rating")
        private String technologyRating;

        /**
         * 图片数
         */
        @JSONField(name="image_num")
        private String imageNum;

        /**
         * 团购数
         */
        @JSONField(name="groupon_num")
        private int grouponNum;

        /**
         * 优惠数
         */
        @JSONField(name="discount_num")
        private int discountNum;

        /**
         * 评论数
         */
        @JSONField(name="comment_num")
        private String commentNum;

        /**
         * 收藏数
         */
        @JSONField(name="favorite_num")
        private String favoriteNum;

        /**
         * 签到数
         */
        @JSONField(name="checkin_num")
        private String checkinNum;

        /**
         * poi对应的品牌（如加油站中的『中石油』、『中石化』）
         */
        private String brand;

        /**
         * poi标签信息
         */
        @JSONField(name="content_tag")
        private String contentTag;


        /**
         * POI对应的导航引导点坐标。大型面状POI的导航引导点，一般为各类出入口，方便结合导航、路线规划等服务使用
         */
        @JSONField(name="navi_location")
        private BaiduMapPlaceSuggestionResult.Location naviLocation;

        /**
         * poi子点数据，若某poi无子点，该字段为空
         */
        private List<BaiduMapPlaceSuggestionResult.Children> children;
    }


    public static <T> T toList(String json,String key){
        JSONObject object = JSONObject.parseObject(json);
        List<BaiduMapPlaceResult> results = object.getJSONArray(key).toJavaList(BaiduMapPlaceResult.class);
        if(object.containsKey("total")){
            ResultDataTable table = ResultDataTable.builder().rows(results).total(object.getInteger("total")).build();
            return (T) table;
        }
        return (T) results;
    }
}
