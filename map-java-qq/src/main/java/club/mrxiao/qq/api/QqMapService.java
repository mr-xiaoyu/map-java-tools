package club.mrxiao.qq.api;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.config.QqMapConfig;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *  腾讯地图api接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-12
 */
public interface QqMapService {

    /**
     * 设置配置
     * @param config {@link QqMapConfig} 配置对象
     */
    void setQqMapConfig(QqMapConfig config);

    /**
     * 获取配置
     * @return {@link QqMapConfig}
     */
    QqMapConfig getQqMapConfig();

    /**
     * 获取搜索服务
     * @return {@link QqMapSearchService}
     */
    QqMapSearchService getQqMapSearchService();

    /**
     * 获取地址服务
     * @return {@link QqMapAddressService}
     */
    QqMapAddressService getQqMapAddressService();

    /**
     * 发送get请求
     * @param url 请求地址
     * @param jsonParam json对象
     * @return  请求结果
     * @exception QqMapErrorException 异常
     */
    String get(String url, JSONObject jsonParam) throws QqMapErrorException;
}
