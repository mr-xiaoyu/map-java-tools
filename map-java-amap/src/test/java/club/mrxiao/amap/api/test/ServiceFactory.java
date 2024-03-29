package club.mrxiao.amap.api.test;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.impl.AmapServiceImpl;
import club.mrxiao.amap.config.AmapConfig;

public class ServiceFactory {

    public static AmapService getAmapService(){
        AmapConfig config = new AmapConfig();
        config.setKey("--");
        AmapService service = new AmapServiceImpl();
        service.setAmapConfig(config);
        return service;
    }
}
