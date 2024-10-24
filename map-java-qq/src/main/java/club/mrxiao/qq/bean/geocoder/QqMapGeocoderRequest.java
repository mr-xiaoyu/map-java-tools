package club.mrxiao.qq.bean.geocoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  腾讯地图地址解析服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
@Builder
public class QqMapGeocoderRequest implements Serializable {

    private static final long serialVersionUID = 5937725670713385919L;

    /**
     * 经纬度（GCJ02坐标系）
     * <pre>
     * 是否必填： 是（逆地址解析时）
     * 格式：
     * location=lat<纬度>,lng<经度>
     * </pre>
     */
    private String location;

    /**
     * 地址
     * <pre>
     * 是否必填： 是（地址解析时）
     * 注：结构化地址，地址中需包含省市区信息，以及需要对地址进行URL编码，否则会影响解析效果
     * </pre>
     */
    private String address;

    /**
     * 是否返回周边地点（POI）列表
     * <pre>
     * 是否必填： 否
     * 可选值：
     * 0 不返回(默认)
     * 1 返回
     * </pre>
     */
    @JSONField(name="get_poi")
    private String getPoi;

    /**
     * 周边POI（AOI）列表控制参数
     * <pre>
     * 是否必填： 否
     * 1 poi_options=address_format=short
     * 返回短地址，缺省时返回长地址
     * 2 poi_options=radius=5000
     * 半径，取值范围 1-5000（米）
     * 3 poi_options=policy=1/2/3/4/5
     * 控制返回场景，
     * policy=1[默认] 以地标+主要的路+近距离POI为主，着力描述当前位置；
     * policy=2 到家场景：筛选合适收货的POI，并会细化收货地址，精确到楼栋；
     * policy=3 出行场景：过滤掉车辆不易到达的POI(如一些景区内POI)，增加道路出入口、交叉口、大区域出入口类POI，排序会根据真实API大用户的用户点击自动优化。
     * policy=4 社交签到场景，针对用户签到的热门 地点进行优先排序。
     * policy=5 位置共享场景，用户经常用于发送位置、位置分享等场景的热门地点优先排序
     * 4 注：policy=1/2/3最多返回10条周边POI，policy=4/5最多返回20条
     * </pre>
     */
    @JSONField(name="poi_options")
    private String poiOptions;

    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
