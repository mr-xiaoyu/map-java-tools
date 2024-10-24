package club.mrxiao.qq.bean.geocoder;

import club.mrxiao.qq.bean.AdInfo;
import club.mrxiao.qq.bean.Location;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  腾讯地图地址解析服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-15
 */
@Data
public class QqMapGeocoderResult implements Serializable {

    private static final long serialVersionUID = -8285479412751358488L;

    /**
     * 坐标
     */
    private Location location;

    /**
     * 解析后的地址部件
     */
    @JSONField(name="address_components")
    private AdInfo addressComponents;

    /**
     * 行政区划信息
     */
    @JSONField(name="ad_info")
    private AdInfo adInfo;

    /**
     * 可信度参考：值范围 1 <低可信> - 10 <高可信>
     * 我们根据用户输入地址的准确程度，在解析过程中，将解析结果的可信度(质量)，由低到高，分为1 - 10级，该值>=7时，解析结果较为准确，<7时，会存各类不可靠因素，开发者可根据自己的实际使用场景，对于解析质量的实际要求，进行参考
     */
    private int reliability;

    /**
     * 解析精度级别，分为11个级别，一般>=9即可采用（定位到点，精度较高） 也可根据实际业务需求自行调整
     */
    private int level;

    public static QqMapGeocoderResult fromJson(String json){
        return JSONObject.parseObject(json).getJSONObject("result").toJavaObject(QqMapGeocoderResult.class);
    }
}
