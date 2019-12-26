package club.mrxiao.baidu.bean.suggestion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      百度地图地点输入提示服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
@Data
@Builder
public class BaiduMapPlaceSuggestionRequest implements Serializable {

    private static final long serialVersionUID = -7231624955441577100L;


    /**
     * 输入建议关键字（支持拼音）
     * <pre>
     * 是否必填： 是
     * 描述： 上地、天安、中关、shanghai
     * </pre>
     */
    private String query;

    /**
     * 支持全国、省、城市及对应百度编码（Citycode）
     * <pre>
     * 是否必填： 是
     * 描述： 全国、北京市、131、江苏省等.（指定的区域的返回结果加权，可能返回其他城市高权重结果。若要对返回结果区域严格限制，请使用city_limit参数）
     * </pre>
     */
    private String region;

    /**
     * 是否仅返回region中指定城市检索结果
     * <pre>
     * 是否必填： 否
     * 描述： 默认false
     * </pre>
     */
    @JSONField(name="city_limit")
    private Boolean cityLimit;

    /**
     * 传入location参数后，返回结果将以距离进行排序
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    private String location;

    /**
     * 坐标类型
     * <pre>
     * 是否必填： 否
     * 描述： 可选参数，用于标注请求中「location」参数使用的坐标类型
     * </pre>
     */
    @JSONField(name="coord_type")
    private Integer coordType;

    /**
     * 返回坐标类型
     * <pre>
     * 是否必填： 否
     * 描述： 可选参数，若不传该参数，返回结果默认bd09ll（百度经纬度）
     * </pre>
     */
    @JSONField(name="ret_coordtype")
    private String retCoordType;


    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
