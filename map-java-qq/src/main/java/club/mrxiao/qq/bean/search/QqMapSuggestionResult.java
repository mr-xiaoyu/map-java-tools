package club.mrxiao.qq.bean.search;

import club.mrxiao.qq.bean.Location;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *  腾讯地图关键词输入提示服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2026-02-28
 */
@Data
public class QqMapSuggestionResult implements Serializable {

    private static final long serialVersionUID = -1624867386024866702L;

    /**
     * 结果总数（注：本服务一个查询条件最多返回100条结果）
     */
    private Integer count;

    /**
     * 提示词数组，每项为一个POI对象
     */
    private List<DataItem> data;


    /**
     * data item
     */
    @Data
    public static class DataItem {

        /**
         * POI唯一标识（type为4时不返回）
         */
        private String id;

        /**
         * 提示文字（地点名称）
         */
        private String title;

        /**
         * 地址（type为4时不返回）
         */
        private String address;

        /**
         * POI（地点）分类（type为4时不返回）
         */
        private String category;

        /**
         * POI（地点）分类编码，设置added_fields=category_code时返回
         */
        @JSONField(name="category_code")
        private String categoryCode;

        /**
         * POI类型，值说明：0:普通POI / 1:公交车站 / 2:地铁站 / 3:公交线路 / 4:行政区划
         */
        private String type;

        /**
         * 传入location（定位坐标）参数时，返回定位坐标到各POI的直线距离，单位：米
         */
        @JSONField(name="_distance")
        private String distance;

        /**
         * 提示所述位置坐标
         */
        private Location location;

        /**
         * 行政区划代码
         */
        private Integer adcode;

        /**
         * 省（type为4时不返回）
         */
        private String province;

        /**
         * 市（type为4时不返回）
         */
        private String city;

        /**
         * 区/县（type为4时不返回），当type（POI类型）为3（公交线路）时，district由city补全
         */
        private String district;
    }

    public static QqMapSuggestionResult fromJson(String json){
        return JSON.toJavaObject(JSON.parseObject(json),QqMapSuggestionResult.class);
    }
}
