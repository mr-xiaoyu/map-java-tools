package club.mrxiao.baidu.bean.geoconv;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *      百度地图坐标转换服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
public class BaiduMapGeoconvResult implements Serializable {

    private static final long serialVersionUID = -807579258819753241L;

    /**
     * 纬度
     */
    private Double y;

    /**
     * 经度
     */
    private Double x;


    public static List<BaiduMapGeoconvResult> toList(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object.getJSONArray("result").toJavaList(BaiduMapGeoconvResult.class);
    }
}
