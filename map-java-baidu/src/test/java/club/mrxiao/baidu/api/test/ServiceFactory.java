package club.mrxiao.baidu.api.test;

import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.api.impl.BaiduMapServiceImpl;
import club.mrxiao.baidu.config.BaiduMapConfig;

public class ServiceFactory {

    public static BaiduMapService getService(){
        BaiduMapConfig config = new BaiduMapConfig();
        config.setAk("5W3c6kUaG48r6I5aRpjuOBM5xGwGaRyQ");
        BaiduMapService service = new BaiduMapServiceImpl();
        service.setBaiduMapConfig(config);
        return service;
    }
}
