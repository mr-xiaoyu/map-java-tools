package club.mrxiao.amap.api.test;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.impl.AmapServiceImpl;
import club.mrxiao.amap.config.AmapConfig;

public class ServiceFactory {

    public static AmapService getAmapService(){
        AmapConfig config = new AmapConfig();
        config.setKey("351cd4d5fe05878a442d94f13436dc88");
        AmapService service = new AmapServiceImpl();
        service.setAmapConfig(config);
        return service;
    }
}
