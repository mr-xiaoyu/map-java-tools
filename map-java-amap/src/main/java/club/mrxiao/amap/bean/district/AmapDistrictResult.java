package club.mrxiao.amap.bean.district;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 行政区域查询响应对象
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-09
 */
@Data
public class AmapDistrictResult implements Serializable {

    private static final long serialVersionUID = 5257342838550354248L;

    /**
     * 城市编码
     */
    private String citycode;

    /**
     * 区域编码
     * <pre>
     *     街道没有独有的adcode，均继承父类（区县）的adcode
     * </pre>
     */
    private String adcode;

    /**
     * 行政区名称
     */
    private String name;


    /**
     * 行政区边界坐标点
     * <pre>
     * 当一个行政区范围，由完全分隔两块或者多块的地块组
     * 成，每块地的 polyline 坐标串以 | 分隔 。
     * 如北京 的 朝阳区
     * </pre>
     */
    private String polyline;

    /**
     * 区域中心点
     */
    private String center;

    /**
     * 行政区划级别
     * <pre>
     * country:国家
     * province:省份（直辖市会在province和city显示）
     * city:市（直辖市会在province和city显示）
     * district:区县
     * street:街道
     * </pre>
     */
    private String level;

    /**
     * 下级行政区列表，包含district元素
     */
    private List<AmapDistrictResult> districts;

    public static List<AmapDistrictResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("districts").toJavaList(AmapDistrictResult.class);
    }
}
