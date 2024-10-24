package club.mrxiao.qq.bean.district;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  腾讯地图行政区划服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
@Builder
public class QqMapDistrictRequest implements Serializable {

    private static final long serialVersionUID = 4460559881984426161L;

    /**
     * 区划列表新结构
     * <pre>
     * 是否必填： 否
     * 描述：
     * 1 新结构，是以省市区实际归属进行嵌套的结构返回
     * </pre>
     */
    @JSONField(name="struct_type")
    private String structType;

    /**
     * 父级行政区划ID（adCode）
     * <pre>
     * 是否必填： 否
     * 描述：
     * 缺省时返回一级行政区划，也就是省级
     */
    private String id;

    /**
     * 返回行政区划轮廓点串（经纬度点串）
     * <pre>
     * 是否必填： 否
     * 描述：
     * 0 默认，不返回轮廓
     * 1 固定3公里抽稀粒度的区划轮廓
     * 2 支持多种抽稀粒度的区划轮廓，可通过max_offset设置返回轮廓的抽稀级别
     * 3 获取乡镇/街道（四级）轮廓边界
     */
    @JSONField(name="get_polygon")
    private String getPolygon;

    /**
     * 轮廓点串的抽稀精度（仅对get_polygon=2时支持）
     * <pre>
     * 是否必填： 否
     * 单位米，可选值：
     * 100 ：100米（当缺省id返回省级区划时，将按500米返回，其它级别正常生效）
     * 500 ：500米
     * 1000：1000米
     * 3000：3000米
     */
    @JSONField(name="max_offset")
    private String maxOffset;



    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
