package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduTraceEntityService;
import club.mrxiao.baidu.api.BaiduTraceService;
import club.mrxiao.baidu.api.BaiduTraceTrackService;
import club.mrxiao.baidu.config.BaiduTraceConfig;
import club.mrxiao.baidu.enums.BaiduTraceStatusEnum;
import club.mrxiao.baidu.exception.BaiduTraceException;
import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 百度鹰眼服务封装
 * @author xiaoyu
 */
public class BaiduTraceServiceImpl implements BaiduTraceService {

    private BaiduTraceConfig baiduTraceConfig;

    private BaiduTraceEntityService entityService = new BaiduTraceEntityServiceImpl(this);
    private BaiduTraceTrackService trackService = new BaiduTraceTrackServiceImpl(this);


    public void setBaiduTraceConfig(BaiduTraceConfig baiduTraceConfig) {
        this.baiduTraceConfig = baiduTraceConfig;
    }

    public BaiduTraceConfig getBaiduTraceConfig() {
        return baiduTraceConfig;
    }


    public JSONObject sendPost(String url, Map<String, Object> param) throws BaiduTraceException {
        param.putAll(baiduTraceConfig.getBaseRequest());
        String result = HttpUtil.post(BAST_URL+url, param);
        if(StrUtil.isNotBlank(result)){
            JSONObject resultObject = JSONObject.parseObject(result);
            if(BaiduTraceStatusEnum.succeed.getCode().equals(resultObject.getInteger(STATUS_FIELD))){
                return resultObject;
            }
            throw new BaiduTraceException(JSON.toJavaObject(resultObject,BaiduTraceBaseResponse.class));
        }
        throw new BaiduTraceException("无返回数据");
    }

    public JSONObject sendGet(String url, Map<String, Object> param) throws BaiduTraceException {
        param.putAll(baiduTraceConfig.getBaseRequest());
        String result =  HttpUtil.get(BAST_URL+url, param);
        if(StrUtil.isNotBlank(result)) {
            JSONObject resultObject = JSONObject.parseObject(result);
            if(BaiduTraceStatusEnum.succeed.getCode().equals(resultObject.getInteger(STATUS_FIELD))){
                return resultObject;
            }
            throw new BaiduTraceException(JSON.toJavaObject(resultObject,BaiduTraceBaseResponse.class));
        }
        throw new BaiduTraceException("无返回数据");
    }

    public BaiduTraceEntityService getEntityService() { return this.entityService; }


    public BaiduTraceTrackService getTrackService() { return this.trackService; }
}
