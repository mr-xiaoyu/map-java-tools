package club.mrxiao.baidu.service;

import club.mrxiao.baidu.request.BaiduTraceCommonRequest;
import club.mrxiao.baidu.service.impl.BaiduTraceEntityServiceImpl;
import club.mrxiao.baidu.service.impl.BaiduTraceServiceImpl;
import club.mrxiao.baidu.config.BaiduTraceConfig;
import club.mrxiao.baidu.request.BaiduTraceEntityRequest;
import org.junit.Test;


public class BaiduTraceServiceTest {

    public BaiduTraceService init(){
        BaiduTraceConfig baiduTraceConfig = new BaiduTraceConfig("*****",202960);
        BaiduTraceService baiduTraceService = new BaiduTraceServiceImpl();
        baiduTraceService.setBaiduTraceConfig(baiduTraceConfig);
        return baiduTraceService;
    }

    @Test
    public void entityAdd() {
        BaiduTraceEntityService baiduTraceEntityService = new BaiduTraceEntityServiceImpl(this.init());
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityName("test").entityDesc("test1");
        baiduTraceEntityService.entityAdd(entityRequest);
    }

    @Test
    public void entityUpdate(){
        BaiduTraceEntityService baiduTraceEntityService = new BaiduTraceEntityServiceImpl(this.init());
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityDesc("test12345").entityName("test");
        baiduTraceEntityService.entityUpdate(entityRequest);
    }

    @Test
    public void entityDelete(){
        BaiduTraceEntityService baiduTraceEntityService = new BaiduTraceEntityServiceImpl(this.init());
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityName("test");
        baiduTraceEntityService.entityDelete(entityRequest);
    }

    @Test
    public void entityList(){
        BaiduTraceEntityService baiduTraceEntityService = new BaiduTraceEntityServiceImpl(this.init());
        BaiduTraceCommonRequest baiduTraceCommonRequest = new BaiduTraceCommonRequest();
        baiduTraceCommonRequest.pageIndex(1).pageSize(2);
        baiduTraceEntityService.entityList(baiduTraceCommonRequest);
    }
}
