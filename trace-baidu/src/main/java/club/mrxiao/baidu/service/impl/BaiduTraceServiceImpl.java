package club.mrxiao.baidu.service.impl;

import club.mrxiao.baidu.service.BaiduTraceService;
import club.mrxiao.baidu.config.BaiduTraceConfig;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.util.Map;

/**
 * 百度鹰眼服务封装
 * @author xiaoyu
 */
public class BaiduTraceServiceImpl implements BaiduTraceService {

    private final Log log = LogFactory.get(this.getClass().getName());

    protected BaiduTraceConfig baiduTraceConfig;

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
}
