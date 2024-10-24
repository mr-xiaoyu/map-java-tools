package test;

import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.api.impl.QqMapServiceImpl;
import club.mrxiao.qq.config.QqMapConfig;

public class ServiceFactory {

    public static QqMapService getService(){
        QqMapConfig config = new QqMapConfig();
        config.setKey("--");
        QqMapService service = new QqMapServiceImpl();
        service.setQqMapConfig(config);
        return service;
    }
}
