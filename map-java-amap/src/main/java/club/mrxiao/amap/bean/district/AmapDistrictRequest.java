package club.mrxiao.amap.bean.district;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 行政区域查询请求对象
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-09
 */
@Data
@Builder
public class AmapDistrictRequest implements Serializable {

    private static final long serialVersionUID = 8683630930213262478L;

    /**
     * 查询关键字
     * <pre>
     * 是否必填: 否
     * 规则：只支持单个关键词语搜索关键词支持：行政区名称、citycode、adcode
     * 例如，在subdistrict=2，搜索省份（例如山东），能够显示市（例如济南），区（例如历下区）
     * </pre>
     */
    private String keywords;

    /**
     * 子级行政区
     * <pre>
     * 是否必填: 否
     * 规则：设置显示下级行政区级数（行政区级别包括：国家、省/直辖市、市、区/县、乡镇/街道多级数据）
     * 可选值：0、1、2、3等数字，并以此类推
     * 0：不返回下级行政区；
     * 1：返回下一级行政区；
     * 2：返回下两级行政区；
     * 3：返回下三级行政区；
     * 需要在此特殊说明，目前部分城市和省直辖县因为没有区县的概念，故在市级下方直接显示街道。
     * 例如：广东-东莞、海南-文昌市
     * </pre>
     */
    private String subdistrict;

    /**
     * 需要第几页数据
     * <pre>
     * 是否必填: 否
     * 最外层的districts最多会返回20个数据，若超过限制，请用page请求下一页数据。
     * 例如page=2；page=3。默认page=1
     * </pre>
     */
    private String page;

    /**
     * 最外层返回数据个数
     * <pre>
     * 是否必填: 否
     * </pre>
     */
    private String offset;

    /**
     * 返回结果控制
     * <pre>
     * 是否必填: 否
     * 此项控制行政区信息中返回行政区边界坐标点； 可选值：base、all;
     * base:不返回行政区边界坐标点；
     * all:只返回当前查询district的边界值，不返回子节点的边界值；
     * 目前不能返回乡镇/街道级别的边界值
     * </pre>
     */
    private String extensions;

    /**
     * 根据区划过滤
     * <pre>
     * 是否必填: 否
     * 按照指定行政区划进行过滤，填入后则只返回该省/直辖市信息
     * 需填入adcode，为了保证数据的正确，强烈建议填入此参数
     * </pre>
     */
    private String filter;

    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
