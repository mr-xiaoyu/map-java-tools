package club.mrxiao.baidu.bean.geocoder;

import club.mrxiao.baidu.bean.suggestion.BaiduMapPlaceSuggestionResult;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      百度地图地理编码服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
public class BaiduMapGeocoderResult implements Serializable {

    private static final long serialVersionUID = 8718275955334068818L;


    /**
     * 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点
     */
    private int precise;


    /**
     * 描述打点绝对精度（即坐标点的误差范围）
     * <pre>
     *     描述:
     *     confidence=100，解析误差绝对精度小于20m；
     *     confidence≥90，解析误差绝对精度小于50m；
     *     confidence≥80，解析误差绝对精度小于100m；
     *     confidence≥75，解析误差绝对精度小于200m；
     *     confidence≥70，解析误差绝对精度小于300m；
     *     confidence≥60，解析误差绝对精度小于500m；
     *     confidence≥50，解析误差绝对精度小于1000m；
     *     confidence≥40，解析误差绝对精度小于2000m；
     *     confidence≥30，解析误差绝对精度小于5000m；
     *     confidence≥25，解析误差绝对精度小于8000m；
     *     confidence≥20，解析误差绝对精度小于10000m；
     * </pre>
     */
    private int confidence;

    /**
     * 描述地址理解程度。分值范围0-100，分值越大，服务对地址理解程度越高（建议以该字段作为解析结果判断标准）
     * <pre>
     *     当comprehension值为以下值时，对应的准确率如下：
     *     comprehension=100，解析误差100m内概率为91%，误差500m内概率为96%；
     *     comprehension≥90，解析误差100m内概率为89%，误差500m内概率为96%；
     *     comprehension≥80，解析误差100m内概率为88%，误差500m内概率为95%；
     *     comprehension≥70，解析误差100m内概率为84%，误差500m内概率为93%；
     *     comprehension≥60，解析误差100m内概率为81%，误差500m内概率为91%；
     *     comprehension≥50，解析误差100m内概率为79%，误差500m内概率为90%；
     *     解析误差：地理编码服务解析地址得到的坐标位置，与地址对应的真实位置间的距离。
     * </pre>
     */
    private int comprehension;

    /**
     * 地址类型
     */
    private String level;


    /**
     * 经纬度坐标
     */
    private BaiduMapPlaceSuggestionResult.Location location;


    public static BaiduMapGeocoderResult fromJson(String json){
        return JSONObject.parseObject(json).getJSONObject("result").toJavaObject(BaiduMapGeocoderResult.class);
    }
}
