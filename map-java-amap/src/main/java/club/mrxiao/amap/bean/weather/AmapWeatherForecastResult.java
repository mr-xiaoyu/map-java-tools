package club.mrxiao.amap.bean.weather;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  天气预报数据信息响应对象
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-01-12
 */
@Data
public class AmapWeatherForecastResult implements Serializable {

    private static final long serialVersionUID = -4128418668175483245L;

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
     * 预报发布时间
     */
    private String reporttime;

    /**
     * 预报数据list结构，元素cast,按顺序为当天、第二天、第三天的预报数据
     */
    private List<Cast> casts;

    /**
     * 预报元素
     */
    @Data
    public static class Cast {
        /**
         * 日期
         */
        private String date;

        /**
         * 星期几
         */
        private String week;

        /**
         * 白天天气现象
         */
        private String dayweather;

        /**
         * 晚上天气现象
         */
        private String nightweather;

        /**
         * 白天温度
         */
        private String daytemp;

        /**
         * 晚上温度
         */
        private String nighttemp;

        /**
         * 白天风向
         */
        private String daywind;

        /**
         * 晚上风向
         */
        private String nightwind;

        /**
         * 白天风力
         */
        private String daypower;

        /**
         * 晚上风力
         */
        private String nightpower;
    }

    public static List<AmapWeatherForecastResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("forecasts").toJavaList(AmapWeatherForecastResult.class);
    }
}
