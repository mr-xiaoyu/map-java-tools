package club.mrxiao.qq.bean.place;

import club.mrxiao.qq.bean.AdInfo;
import club.mrxiao.qq.bean.Location;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *      腾讯地图地点搜索服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
public class QqMapPlaceResult implements Serializable {

    private static final long serialVersionUID = 473118054658499650L;

    /**
     * 本次搜索结果总数，另外本服务限制最多返回200条数据(data)，
     * 翻页（page_index）超过搜索结果总数返回空，未超过搜索总数但超过200条限制时，将返回最后一页数据。
     */
    private Integer count;

    /**
     * 搜索结果POI（地点）数组，每项为一个POI（地点）对象
     */
    private List<DataItem> data;

    /**
     * 子地点列表，仅在输入参数get_subpois=1时返回
     */
    @JSONField(name="sub_pois")
    private List<DataItem> subPois;

    /**
     * 统计结果数组
     */
    private List<ClusterItem> cluster;

    /**
     * data item
     */
    @Data
    public static class DataItem {

        /**
         * 主地点ID，对应data中的地点ID
         */
        @JSONField(name="parent_id")
        private String parentId;

        /**
         * POI（地点）唯一标识
         */
        private String id;

        /**
         * POI（地点）名称
         */
        private String title;

        /**
         * 地址
         */
        private String address;

        /**
         * 电话
         */
        private String tel;

        /**
         * POI（地点）分类
         */
        private String category;

        /**
         * POI（地点）分类编码，设置added_fields=category_code时返回
         */
        @JSONField(name="category_code")
        private Integer categoryCode;

        /**
         * POI类型，值说明：0:普通POI / 1:公交车站 / 2:地铁站 / 3:公交线路 / 4:行政区划
         */
        private Integer type;

        /**
         * 坐标
         */
        private Location location;

        /**
         * 行政区划信息
         */
        @JSONField(name="ad_info")
        private AdInfo adInfo;

        /**
         * 距离，单位： 米，在周边搜索、城市范围搜索传入定位点时返回
         */
        @JSONField(name="_distance")
        private Double distance;
    }

    /**
     * 统计结果
     */
    @Data
    public static class ClusterItem {

        /**
         * 城市名称
         */
        private String title;

        /**
         * 根据搜索条件，在该城市搜到的结果数
         */
        private Integer count;
    }

    public static QqMapPlaceResult fromJson(String json){
        return JSONObject.parseObject(json).toJavaObject(QqMapPlaceResult.class);
    }
}
