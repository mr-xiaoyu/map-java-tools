package club.mrxiao.amap.bean.weather;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *  高德天气信息请求对象
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
@Data
@Builder
public class AmapWeatherInfoRequest implements Serializable {

    private static final long serialVersionUID = 6898855774969997295L;

    /**
     * 城市编码
     * <pre>
     *     是否必填： 是<br/>
     *     输入城市的adcode，adcode信息可参考城市<a href="https://lbs.amap.com/api/webservice/download">编码表</a>
     * </pre>
     */
    private String city;

    /**
     * 气象类型
     * <pre>
     *    是否必填： 否<br/>
     *    可选值：base/all<br/>
     *    base:返回实况天气<br/>
     *    all:返回预报天气<br/>
     * </pre>
     *
     */
    private String extensions;


    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
