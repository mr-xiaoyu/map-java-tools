package club.mrxiao.qq.bean.district;

import club.mrxiao.qq.bean.Location;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  <pre>
 *  腾讯地图行政区划服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QqMapDistrictResult implements Serializable {

    private static final long serialVersionUID = 4414112017981296020L;

    /**
     * 行政区划数据版本
     */
    @JSONField(name="data_version")
    private String dataVersion;

    /**
     * 列表
     */
    private List<List<DistrictItem>> list;

    /**
     * 树形菜单
     */
    private List<DistrictItem> tree;

    @Data
    public static class DistrictItem {
        /**
         * 行政区划唯一标识（adCode）
         */
        private String id;

        /**
         * 简称，如“内蒙古”
         */
        private String name;

        /**
         * 全称，如“内蒙古自治区”
         */
        @JSONField(name="fullname")
        private String fullName;

        /**
         * 经纬度
         */
        private Location location;

        /**
         * 行政区划拼音，每一下标为一个字的全拼
         */
        private List<String> pinyin;

        /**
         * 该行政区划的轮廓经纬度点串（当使用get_polygon=1或2时返回），数组每一项为一个多边形，一个行政区划可以由多块多边形组成
         * 注意：部分城市存在飞地，当两个polygon重叠时，重叠区域隶属其他城市，不重叠时代表此城市的飞地
         */
        private List<List<String>> polygon;

        /**
         * 当前区划的下级区划信息，结构与当前区划一致，如果没有下级区划则不返回此字段
         */
        List<DistrictItem> districts;
    }

    public static QqMapDistrictResult fromJson(String json){
        QqMapDistrictResult result = new QqMapDistrictResult();
        List<List<DistrictItem>> list = new ArrayList<>();
        JSONObject object = JSONObject.parseObject(json);
        JSONArray array = object.getJSONArray("result");
        for (Object o : array) {
            JSONArray item = (JSONArray) o;
            list.add(item.toJavaList(QqMapDistrictResult.DistrictItem.class));
        }
        result.setList(list);
        result.setDataVersion(object.getString("data_version"));
        return result;
    }

    public static QqMapDistrictResult treeFromJson(String json){
        QqMapDistrictResult result = new QqMapDistrictResult();
        JSONObject object = JSONObject.parseObject(json);
        JSONArray array = object.getJSONArray("result");
        List<DistrictItem> tree = array.toJavaList(QqMapDistrictResult.DistrictItem.class);
        result.setTree(tree);
        result.setDataVersion(object.getString("data_version"));
        return result;
    }
}
