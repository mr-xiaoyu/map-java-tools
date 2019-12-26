package club.mrxiao.baidu.bean.geoconv;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      百度地图坐标转换服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
@Builder
public class BaiduMapGeoconvRequest implements Serializable  {

    private static final long serialVersionUID = -3856262638881883581L;


    /**
     * 需转换的源坐标，多组坐标以“；”分隔(经度，纬度）
     * <pre>
     * 是否必填： 是
     * </pre>
     */
    private String coords;

    /**
     * 源坐标类型
     * <pre>
     * 是否必填： 否
     * 描述：
     * 1：GPS设备获取的角度坐标，WGS84坐标;
     * 2：GPS获取的米制坐标、sogou地图所用坐标;
     * 3：google地图、soso地图、aliyun地图、mapabc地图和amap地图所用坐标，国测局（GCJ02）坐标;
     * 4：3中列表地图坐标对应的米制坐标;
     * 5：百度地图采用的经纬度坐标;
     * 6：百度地图采用的米制坐标;
     * 7：mapbar地图坐标;
     * 8：51地图坐标
     * </pre>
     */
    private Integer from;

    /**
     * 目标坐标类型
     * <pre>
     * 是否必填： 否
     * 描述：
     * 5：bd09ll(百度经纬度坐标);
     * 6：bd09mc(百度米制经纬度坐标)
     * </pre>
     */
    private Integer to;


    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
