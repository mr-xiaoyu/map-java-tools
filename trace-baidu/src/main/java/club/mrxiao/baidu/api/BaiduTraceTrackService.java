package club.mrxiao.baidu.api;

import club.mrxiao.baidu.domain.BaiduTraceTrackPoint;

import java.util.List;

/**
 * 上传轨迹点
 * @author xiaoyu
 */
public interface BaiduTraceTrackService {

    String TRACK_ADDPOINT = "track/addpoint";

    String TRACK_ADDPOINTS = "track/addpoints";


    /**
     *  上传单个轨迹点
     * @param entityName
     * @param baiduTraceTrackPoint
     */
    void trackAddPoint(String entityName,BaiduTraceTrackPoint baiduTraceTrackPoint);

    /**
     * 批量添加轨迹点
     * @param entityName
     * @param baiduTraceTrackPoints
     */
    void trackAddPoints(String entityName, List<BaiduTraceTrackPoint> baiduTraceTrackPoints);
}
