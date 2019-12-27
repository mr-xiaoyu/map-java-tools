package club.mrxiao.baidu.bean.geocoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      百度地图地理编码服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
@Builder
public class BaiduMapGeocoderRequest implements Serializable {

    private static final long serialVersionUID = -8069915319684219786L;

    /**
     * 待解析的地址
     * <pre>
     * 是否必填： 是
     * 描述： 最多支持84个字节;可以输入两种样式的值，分别是：
     *      1、标准的结构化地址信息，如北京市海淀区上地十街十号 【推荐，地址结构越完整，解析精度越高】
     *      2、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口
     *      第二种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
     * </pre>
     */
    private String address;

    /**
     * 地址所在的城市名
     * <pre>
     * 是否必填： 否
     * 描述： 用于指定上述地址所在的城市，当多个城市都有上述地址时，该参数起到过滤作用，但不限制坐标召回城市
     * </pre>
     */
    private String city;

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
