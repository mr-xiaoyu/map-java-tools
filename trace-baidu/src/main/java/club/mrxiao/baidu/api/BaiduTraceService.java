package club.mrxiao.baidu.api;

import club.mrxiao.baidu.config.BaiduTraceConfig;

import java.util.Map;

/**
 * 百度鹰眼服务封装
 * @author xiaoyu
 */
public interface BaiduTraceService {

    String BAST_URL = "http://yingyan.baidu.com/api/v3/";

    /**
     * 设置配置
     * @param baiduTraceConfig 配置
     */
    void setBaiduTraceConfig(BaiduTraceConfig baiduTraceConfig);

    /**
     * 获取配置
     * @return 配置
     */
    BaiduTraceConfig getBaiduTraceConfig();

    /**
     * post请求
     * @param url
     * @param param
     * @return
     */
    String sendPost(String url, Map<String,Object> param);

    /**
     * grt请求
     * @param url
     * @param param
     * @return
     */
    String sendGet(String url, Map<String,Object> param);

    /**
     *  返回终端管理相关服务.
     * @return
     */
    BaiduTraceEntityService getEntityService();
}
