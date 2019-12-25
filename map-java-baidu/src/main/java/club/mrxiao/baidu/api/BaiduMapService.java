package club.mrxiao.baidu.api;

import club.mrxiao.baidu.config.BaiduMapConfig;

/**
 * 百度地图api接口
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
public interface BaiduMapService {

    /**
     * 设置配置
     * @param baiduMapConfig {@link BaiduMapConfig} 配置对象
     */
    void setBaiduMapConfig(BaiduMapConfig baiduMapConfig);

    /**
     * 获取配置
     * @return {@link BaiduMapConfig} 配置对象
     */
    BaiduMapConfig getBaiduMapConfig();
}
