package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduTraceService;
import club.mrxiao.baidu.api.BaiduTraceTrackService;
import club.mrxiao.baidu.domain.BaiduTraceTrackPoint;
import club.mrxiao.baidu.exception.BaiduTraceException;
import club.mrxiao.baidu.request.BaiduTrackPointUploadRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyu
 * 上传轨迹点
 */
public class BaiduTraceTrackServiceImpl implements BaiduTraceTrackService {

    private final Log log = LogFactory.get(this.getClass().getName());

    private final BaiduTraceService baiduTraceService;

    public BaiduTraceTrackServiceImpl(BaiduTraceService baiduTraceService){
        this.baiduTraceService = baiduTraceService;
    }

    @Override
    public void trackAddPoint(String entityName, BaiduTraceTrackPoint baiduTraceTrackPoint) throws BaiduTraceException {
        BaiduTrackPointUploadRequest request = new BaiduTrackPointUploadRequest(entityName,baiduTraceTrackPoint);
        JSONObject result = this.baiduTraceService.sendPost(TRACK_ADDPOINT,request);
        log.info("result:{}",result);
    }

    @Override
    public void trackAddPoints(String entityName, List<BaiduTraceTrackPoint> baiduTraceTrackPoints) throws BaiduTraceException {
        if(MAX_SIZE >= baiduTraceTrackPoints.size() && baiduTraceTrackPoints.size() > 0){
            List<Map<String,Object>> pointList = new ArrayList<Map<String, Object>>();
            for(BaiduTraceTrackPoint trackPoint : baiduTraceTrackPoints){
                pointList.add(new BaiduTrackPointUploadRequest(entityName,trackPoint));
            }
            Map<String,Object> param = new HashMap<String, Object>(2);
            param.put("point_list",JSONUtil.toJsonStr(pointList));
            JSONObject result = this.baiduTraceService.sendPost(TRACK_ADDPOINTS,param);
            log.info("result:{}",result);
        }
    }
}
