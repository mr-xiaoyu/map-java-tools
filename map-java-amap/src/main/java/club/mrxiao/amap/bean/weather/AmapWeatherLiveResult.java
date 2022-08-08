package club.mrxiao.amap.bean.weather;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  实况天气数据信息响应对象
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
@Data
public class AmapWeatherLiveResult implements Serializable {

    private static final long serialVersionUID = 634061245171127042L;

    /**
     * 省份名
     */
    private String province;

    /**
     * 城市名
     */
    private String city;

    /**
     * 区域编码
     */
    private String adcode;

    /**
     * 天气现象（汉字描述）
     */
    private String weather;

    /**
     * 实时气温，单位：摄氏度
     */
    private String temperature;

    /**
     * 风向描述
     */
    private String winddirection;

    /**
     * 风力级别，单位：级
     */
    private String windpower;

    /**
     * 空气湿度
     */
    private String humidity;

    /**
     * 数据发布的时间
     */
    private String reporttime;

    public static List<AmapWeatherLiveResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("lives").toJavaList(AmapWeatherLiveResult.class);
    }
}
