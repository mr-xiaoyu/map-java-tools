package club.mrxiao.qq.bean.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  腾讯地图关键词输入提示服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2026-02-28
 */
@Data
@Builder
public class QqMapSuggestionRequest implements Serializable {

    private static final long serialVersionUID = 6942955991016232634L;

    /**
     * 搜索关键词
     * <pre>
     * 是否必填： 是
     * </pre>
     */
    @JSONField(name="keyword")
    private String keyword;

    /**
     * 限制城市范围
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="region")
    private String region;

    /**
     * 是否限制城市范围
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="region_fix")
    private Integer regionFix;

    /**
     * 定位坐标
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="location")
    private String location;

    /**
     * 是否返回子地点
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="get_subpois")
    private Integer getSubpois;

    /**
     * 是否返回区划结果
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="get_ad")
    private Integer getAd;

    /**
     * 检索策略
     * <pre>
     * 是否必填： 否
     * 目前支持：
     * policy=0：默认，常规策略
     * policy=1：本策略主要用于收货地址、上门服务地址的填写，
     * 提高了小区类、商务楼宇、大学等分类的排序，过滤行政区、
     * 道路等分类（如海淀大街、朝阳区等），排序策略引入真实用户对输入提示的点击热度，
     * 使之更为符合此类应用场景，体验更为舒适
     * policy=10：出行场景（网约车） – 起点查询
     * policy=11：出行场景（网约车） – 终点查询
     * </pre>
     */
    @JSONField(name="policy")
    private Integer policy;

    /**
     * 筛选条件
     * <pre>
     * 是否必填： 否
     * </pre>
     */
    @JSONField(name="filter")
    private String filter;

    /**
     * 返回指定标准附加字段
     * <pre>
     * 是否必填： 否
     * 取值支持：
     * category_code - poi分类编码
     * </pre>
     */
    @JSONField(name="added_fields")
    private String addedFields;

    /**
     * 返回“不带行政区划的”短地址
     * <pre>
     * 是否必填： 否
     * 可选值：short
     * </pre>
     */
    @JSONField(name="address_format")
    private String addressFormat;

    /**
     * 页码
     * <pre>
     * 是否必填： 否
     * 从1开始，最大页码需通过count进行计算，必须与page_size同时使用
     * </pre>
     */
    @JSONField(name="page_index")
    private Integer pageIndex;

    /**
     * 每页条数
     * <pre>
     * 是否必填： 否
     * 取值范围1-20，必须与page_index 同时使用
     * </pre>
     */
    @JSONField(name="page_size")
    private Integer pageSize;

    /**
     * 返回格式
     * <pre>
     * 是否必填： 否
     * 支持JSON/JSONP，默认JSON
     * </pre>
     */
    @JSONField(name="output")
    private String output;

    /**
     * 返回格式
     * <pre>
     * 是否必填： 否
     * JSONP方式回调函数
     * </pre>
     */
    @JSONField(name="callback")
    private String callback;

    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
