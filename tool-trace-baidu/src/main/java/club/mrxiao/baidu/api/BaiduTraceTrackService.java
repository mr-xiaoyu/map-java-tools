package club.mrxiao.baidu.api;

import club.mrxiao.baidu.domain.BaiduTraceTrackPoint;
import club.mrxiao.baidu.exception.BaiduTraceException;

import java.util.List;

/**
 * 上传轨迹点
 * @author xiaoyu
 */
public interface BaiduTraceTrackService {

    String TRACK_ADDPOINT = "track/addpoint";

    String TRACK_ADDPOINTS = "track/addpoints";

    /**
     * 轨迹点总数不超过100个
     */
    Integer MAX_SIZE = 100;

    /**
     *  上传单个轨迹点
     * @param entityName
     * @param baiduTraceTrackPoint
     */
    void trackAddPoint(String entityName,BaiduTraceTrackPoint baiduTraceTrackPoint) throws BaiduTraceException;

    /**
     * 批量添加轨迹点
     * @param entityName
     * @param baiduTraceTrackPoints
     */
    void trackAddPoints(String entityName, List<BaiduTraceTrackPoint> baiduTraceTrackPoints) throws BaiduTraceException;
}
