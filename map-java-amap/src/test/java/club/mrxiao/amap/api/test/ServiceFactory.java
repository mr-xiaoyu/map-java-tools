package club.mrxiao.amap.api.test;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.impl.AmapServiceImpl;
import club.mrxiao.amap.config.AmapConfig;

public class ServiceFactory {

    public static AmapService getAmapService(){
        AmapConfig config = new AmapConfig();
        config.setKey("56485da3e807f597e062761bb18b2729");
        AmapService service = new AmapServiceImpl();
        service.setAmapConfig(config);
        return service;
    }
}
