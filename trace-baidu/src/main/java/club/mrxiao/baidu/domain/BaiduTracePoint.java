package club.mrxiao.baidu.domain;

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
    private double latitude;

    /**
     * 经度
     */
    private double longitude;

    /**
     * 坐标类型
     */
    private String coordTypeInput;

    /**
     * 定位精度（单位：m）
     */
    private double radius;

    /**
     * 定位时间
     */
    private long locTime;

    /**
     * 方向（范围为[0,359]，0度为正北方向，顺时针）
     */
    private int direction;

    /**
     * 速度（单位：km/h）
     */
    protected double speed;

    /**
     * 高度（单位：m）
     */
    private double height;

}
