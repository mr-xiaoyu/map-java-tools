package club.mrxiao.baidu.bean.suggestion;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *      百度地图地点输入提示服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
public class BaiduMapPlaceSuggestionResult  implements Serializable {

    private static final long serialVersionUID = -2095240778825011067L;

    /**
     * poi名称
     */
    private String name;

    /**
     * poi的唯一标示，ID
     */
    private String uid;

    /**
     * 省
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县
     */
    private String district;

    /**
     * poi分类。默认不召回，若有需求请联系我们(完成企业认证后，才能开通权限)
     */
    private String tag;

    /**
     * poi地址。默认不召回，若有需求请联系我们(完成企业认证后，才能开通权限)
     */
    private String address;

    /**
     * poi经纬度坐标
     */
    private Location location;

    /**
     * poi子点。默认不召回，若有需求请联系我们；地点输入提示中的子点为简要信息，无poi坐标，如需要坐标，可通过返回的子点uid，使用地点检索中的地点详情检索功能检索坐标信息。(完成企业认证后，才能开通权限)
     */
    private List<Children> children;

    /**
     * poi经纬度坐标
     */
    @Data
    private static class Location{

        /**
         * 纬度
         */
        private Double lat;

        /**
         * 经度
         */
        private Double lng;
    }

    @Data
    private static class Children{

        /**
         * 子点ID，可用于poi详情检索。默认不召回，若有需求请联系我们(完成企业认证后，才能开通权限)
         */
        private String uid;

        /**
         * poi子点名称。默认不召回，若有需求请联系我们(完成企业认证后，才能开通权限)
         */
        private String name;

        /**
         * poi子点简称。默认不召回，若有需求请联系我们(完成企业认证后，才能开通权限)
         */
        @JSONField(name="show_name")
        private String showName;
    }


    public static List<BaiduMapPlaceSuggestionResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("result").toJavaList(BaiduMapPlaceSuggestionResult.class);
    }
}
