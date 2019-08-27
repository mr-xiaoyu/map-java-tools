package club.mrxiao.baidu.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 百度鹰眼轨迹点
 * @author xiaoyu
 */
@Data
public class BaiduTracePoint {

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 坐标类型
     */
    @JSONField(name="coord_type_input")
    private String coordTypeInput;

    /**
     * 定位精度（单位：m）
     */
    private Double radius;

    /**
     * 定位时间
     */
    @JSONField(name="loc_time")
    private Long locTime;

    /**
     * 方向（范围为[0,359]，0度为正北方向，顺时针）
     */
    private Integer direction;

    /**
     * 速度（单位：km/h）
     */
    protected Double speed;

    /**
     * 高度（单位：m）
     */
    private Double height;

}
