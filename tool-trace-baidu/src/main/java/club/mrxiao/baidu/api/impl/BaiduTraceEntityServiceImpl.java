package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.exception.BaiduTraceException;
import club.mrxiao.baidu.request.BaiduTraceCommonRequest;
import club.mrxiao.baidu.request.BaiduTraceEntityRequest;
import club.mrxiao.baidu.api.BaiduTraceEntityService;
import club.mrxiao.baidu.api.BaiduTraceService;
import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import club.mrxiao.baidu.response.BaiduTraceEntityListResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 终端管理类接口
 * @author xiaoyu
 */
public class BaiduTraceEntityServiceImpl implements BaiduTraceEntityService {

    private final BaiduTraceService baiduTraceService;

    public BaiduTraceEntityServiceImpl(BaiduTraceService baiduTraceService){
        this.baiduTraceService = baiduTraceService;
    }

    public BaiduTraceBaseResponse entityAdd(BaiduTraceEntityRequest baiduTraceEntityRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendPost(ENTITY_ADD,baiduTraceEntityRequest);
        return JSON.toJavaObject(result,BaiduTraceBaseResponse.class);
    }

    public BaiduTraceBaseResponse entityUpdate(BaiduTraceEntityRequest baiduTraceEntityRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendPost(ENTITY_UPDATE,baiduTraceEntityRequest);
        return JSON.toJavaObject(result,BaiduTraceBaseResponse.class);
    }

    public BaiduTraceBaseResponse entityDelete(BaiduTraceEntityRequest baiduTraceEntityRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendPost(ENTITY_DELETE,baiduTraceEntityRequest);
        return JSON.toJavaObject(result,BaiduTraceBaseResponse.class);
    }

    public BaiduTraceEntityListResponse entityList(BaiduTraceCommonRequest baiduTraceCommonRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendGet(ENTITY_LIST,baiduTraceCommonRequest);
        return JSON.toJavaObject(result,BaiduTraceEntityListResponse.class);
    }
}
