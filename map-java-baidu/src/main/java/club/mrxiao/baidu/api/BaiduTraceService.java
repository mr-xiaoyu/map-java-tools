package club.mrxiao.baidu.api;

import club.mrxiao.baidu.config.BaiduTraceConfig;
import club.mrxiao.baidu.exception.BaiduTraceException;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 百度鹰眼服务封装
 * @author xiaoyu
 */
public interface BaiduTraceService {

    String BAST_URL = "http://yingyan.baidu.com/api/v3/";

    String STATUS_FIELD = "status";

    String MESSAGE_FIELD = "message";

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
     * @throws BaiduTraceException
     */
    JSONObject sendPost(String url, Map<String,Object> param) throws BaiduTraceException;

    /**
     * grt请求
     * @param url
     * @param param
     * @return
     * @throws BaiduTraceException
     */
    JSONObject sendGet(String url, Map<String,Object> param) throws BaiduTraceException;

    /**
     *  返回终端管理相关服务.
     * @return
     */
    BaiduTraceEntityService getEntityService();

    /**
     * 返回上传轨迹点对象
     * @return
     */
    BaiduTraceTrackService getTrackService();
}
