package club.mrxiao.baidu.api;

import club.mrxiao.baidu.request.BaiduTraceCommonRequest;
import club.mrxiao.baidu.api.impl.BaiduTraceServiceImpl;
import club.mrxiao.baidu.config.BaiduTraceConfig;
import club.mrxiao.baidu.request.BaiduTraceEntityRequest;
import org.junit.Test;


public class BaiduTraceServiceTest {

    public BaiduTraceService init(){
        BaiduTraceConfig baiduTraceConfig = new BaiduTraceConfig("mYSzoaLtqidQe4SxIg6EpfsVme8OqRhK",202960);
        BaiduTraceService baiduTraceService = new BaiduTraceServiceImpl();
        baiduTraceService.setBaiduTraceConfig(baiduTraceConfig);
        return baiduTraceService;
    }

    @Test
    public void entityAdd() {
        BaiduTraceService service = this.init();
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityName("test").entityDesc("test1");
        service.getEntityService().entityAdd(entityRequest);
    }

    @Test
    public void entityUpdate(){
        BaiduTraceService service = this.init();
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityDesc("test12345").entityName("test");
        service.getEntityService().entityUpdate(entityRequest);
    }

    @Test
    public void entityDelete(){
        BaiduTraceService service = this.init();
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityName("test");
        service.getEntityService().entityDelete(entityRequest);
    }

    @Test
    public void entityList(){
        BaiduTraceService service = this.init();
        BaiduTraceCommonRequest baiduTraceCommonRequest = new BaiduTraceCommonRequest();
        baiduTraceCommonRequest.pageIndex(1).pageSize(2);
        service.getEntityService().entityList(baiduTraceCommonRequest);
    }
}
