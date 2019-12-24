package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduTraceService;
import club.mrxiao.baidu.api.BaiduTraceTrackService;
import club.mrxiao.baidu.domain.BaiduTraceTrackPoint;
import club.mrxiao.baidu.exception.BaiduTraceException;
import club.mrxiao.baidu.request.BaiduTrackPointUploadRequest;
import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import club.mrxiao.baidu.response.BaiduTraceTrackAddPointsResponse;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyu
 * 上传轨迹点
 */
public class BaiduTraceTrackServiceImpl implements BaiduTraceTrackService {

    private final BaiduTraceService baiduTraceService;

    public BaiduTraceTrackServiceImpl(BaiduTraceService baiduTraceService){
        this.baiduTraceService = baiduTraceService;
    }


    public BaiduTraceBaseResponse trackAddPoint(BaiduTraceTrackPoint baiduTraceTrackPoint) throws BaiduTraceException {
        BaiduTrackPointUploadRequest request = new BaiduTrackPointUploadRequest(baiduTraceTrackPoint);
        JSONObject result = this.baiduTraceService.sendPost(TRACK_ADDPOINT,request);
        return JSON.toJavaObject(result,BaiduTraceBaseResponse.class);
    }


    public BaiduTraceTrackAddPointsResponse trackAddPoints(List<BaiduTraceTrackPoint> baiduTraceTrackPoints) throws BaiduTraceException {
        if(MAX_SIZE >= baiduTraceTrackPoints.size() && baiduTraceTrackPoints.size() > 0){
            Map<String,Object> param = new HashMap<String, Object>(2);
            param.put("point_list",JSON.toJSONString(baiduTraceTrackPoints));
            JSONObject result = this.baiduTraceService.sendPost(TRACK_ADDPOINTS,param);
            return JSON.toJavaObject(result,BaiduTraceTrackAddPointsResponse.class);
        }
        throw new BaiduTraceException("轨迹点信息参数错误，过长或为空");
    }
}
