package club.mrxiao.baidu.api.impl;

import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.config.BaiduMapConfig;

/**
 * 百度地图api接口实现
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-25
 */
public class BaiduMapServiceImpl implements BaiduMapService {

    private BaiduMapConfig baiduMapConfig;


    public BaiduMapConfig getBaiduMapConfig() {
        return baiduMapConfig;
    }

    public void setBaiduMapConfig(BaiduMapConfig baiduMapConfig) {
        this.baiduMapConfig = baiduMapConfig;
    }
}
