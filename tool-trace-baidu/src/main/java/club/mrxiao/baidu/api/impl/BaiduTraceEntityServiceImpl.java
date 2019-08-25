package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.exception.BaiduTraceException;
import club.mrxiao.baidu.request.BaiduTraceCommonRequest;
import club.mrxiao.baidu.request.BaiduTraceEntityRequest;
import club.mrxiao.baidu.api.BaiduTraceEntityService;
import club.mrxiao.baidu.api.BaiduTraceService;
import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 终端管理类接口
 * @author xiaoyu
 */
public class BaiduTraceEntityServiceImpl implements BaiduTraceEntityService {

    private final Log log = LogFactory.get(this.getClass().getName());

    private final BaiduTraceService baiduTraceService;

    public BaiduTraceEntityServiceImpl(BaiduTraceService baiduTraceService){
        this.baiduTraceService = baiduTraceService;
    }

    @Override
    public void entityAdd(BaiduTraceEntityRequest baiduTraceEntityRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendPost(ENTITY_ADD,baiduTraceEntityRequest);
        BaiduTraceBaseResponse baiduTraceBaseResponse = result.toBean(BaiduTraceBaseResponse.class);
        log.info("result:{}",result);
    }

    @Override
    public void entityUpdate(BaiduTraceEntityRequest baiduTraceEntityRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendPost(ENTITY_UPDATE,baiduTraceEntityRequest);
        log.info("result:{}",result);
    }

    @Override
    public void entityDelete(BaiduTraceEntityRequest baiduTraceEntityRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendPost(ENTITY_DELETE,baiduTraceEntityRequest);
        log.info("result:{}",result);
    }

    @Override
    public void entityList(BaiduTraceCommonRequest baiduTraceCommonRequest) throws BaiduTraceException {
        JSONObject result= this.baiduTraceService.sendGet(ENTITY_LIST,baiduTraceCommonRequest);
        log.info("result:{}",result);
    }
}
