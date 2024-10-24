package club.mrxiao.qq.bean.place;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  腾讯地图地点搜索服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-12
 */
@Data
@Builder
public class QqMapPlaceRequest implements Serializable {

    private static final long serialVersionUID = -4143484222869165908L;


    /**
     * 搜索关键字
     * <pre>
     * 是否必填： 是
     * 描述： keyword仅支持检索一个
     * </pre>
     */
    private String keyword;

    /**
     * <pre>
     * 是否必填： 是
     * 格式：
     * boundary=nearby(lat,lng,radius[, auto_extend])
     * 子参数：
     * lat,lng：搜索中心点的经纬度，格式顺序为纬度在前，经度在后
     * radius：搜索半径，单位：米，取值范围：10到1000
     * auto_extend：[可选] 是否自动扩大范围，取值：
     * 0 不扩大
     * 1 [默认] 自动扩大范围（依次按照按1公里、2公里、5公里，
     * 最大到全城市范围搜索）
     * </pre>
     */
    private String boundary;

    /**
     * 是否返回子地点，如大厦停车场、出入口等
     * <pre>
     * 是否必填： 否
     * 描述：
     * 0 [默认]不返回
     * 1 返回
     * </pre>
     */
    @JSONField(name="get_subpois")
    private String getSubpois;

    /**
     * 筛选条件
     * <pre>
     * 是否必填： 否
     * 描述：
     * 1. 指定分类筛选，语句格式为：
     * category=分类名1,分类名2
     * 分类词数量建议不超过5个，支持设置分类编码（支持的分类请参考：POI分类表）
     * 2. 排除指定分类，语句格式为：
     * category<>分类名1,分类名2
     * 分类词数量建议不超过5个，支持设置分类编码（支持的分类请参考：POI分类表）
     * 3. 筛选有电话的地点：tel<>null
     * </pre>
     */
    private String filter;

    /**
     * 返回指定标准附加字段
     * <pre>
     * 是否必填： 否
     * 描述：
     * category_code - poi分类编码
     * </pre>
     */
    @JSONField(name="added_fields")
    private String addedFields;

    /**
     * 排序，支持按距离由近到远排序，取值：_distance
     * <pre>
     * 是否必填： 否
     * 说明：
     * 1. 周边搜索默认排序会综合考虑距离、权重等多方面因素
     * 2. 设置按距离排序后则仅考虑距离远近，一些低权重的地点可能因距离近排在前面，导致体验下降
     * </pre>
     */
    private String orderby;

    /**
     * 每页条目数，最大限制为20条，默认为10条
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="page_size")
    private String pageSize;

    /**
     * 第x页，默认第1页
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="page_index")
    private String pageIndex;

    /**
     * 返回格式
     * <pre>
     * 是否必填： 否
     * 描述：
     * 支持JSON/JSONP，默认JSON
     * </pre>
     */
    private String output;

    /**
     * JSONP方式回调函数
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    private String callback;

    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
