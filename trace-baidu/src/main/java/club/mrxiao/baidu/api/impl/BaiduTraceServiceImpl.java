package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduTraceEntityService;
import club.mrxiao.baidu.api.BaiduTraceService;
import club.mrxiao.baidu.api.BaiduTraceTrackService;
import club.mrxiao.baidu.config.BaiduTraceConfig;
import cn.hutool.http.HttpUtil;

import java.util.Map;

/**
 * 百度鹰眼服务封装
 * @author xiaoyu
 */
public class BaiduTraceServiceImpl implements BaiduTraceService {

    private BaiduTraceConfig baiduTraceConfig;

    private BaiduTraceEntityService entityService = new BaiduTraceEntityServiceImpl(this);
    private BaiduTraceTrackService trackService = new BaiduTraceTrackServiceImpl(this);

    @Override
    public void setBaiduTraceConfig(BaiduTraceConfig baiduTraceConfig) {
        this.baiduTraceConfig = baiduTraceConfig;
    }

    @Override
    public BaiduTraceConfig getBaiduTraceConfig() {
        return baiduTraceConfig;
    }


    @Override
    public String sendPost(String url, Map<String, Object> param) {
        param.putAll(baiduTraceConfig.getBaseRequest());
        return HttpUtil.post(BAST_URL+url, param);
    }

    @Override
    public String sendGet(String url, Map<String, Object> param) {
        param.putAll(baiduTraceConfig.getBaseRequest());
        return HttpUtil.get(BAST_URL+url, param);
    }

    @Override
    public BaiduTraceEntityService getEntityService() { return this.entityService; }

    @Override
    public BaiduTraceTrackService getTrackService() { return this.trackService; }
}
