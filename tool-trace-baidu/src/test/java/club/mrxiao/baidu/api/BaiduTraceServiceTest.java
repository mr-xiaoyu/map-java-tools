package club.mrxiao.baidu.api;

import club.mrxiao.baidu.domain.BaiduTraceTrackPoint;
import club.mrxiao.baidu.exception.BaiduTraceException;
import club.mrxiao.baidu.request.BaiduTraceCommonRequest;
import club.mrxiao.baidu.api.impl.BaiduTraceServiceImpl;
import club.mrxiao.baidu.config.BaiduTraceConfig;
import club.mrxiao.baidu.request.BaiduTraceEntityRequest;
import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import club.mrxiao.baidu.response.BaiduTraceEntityListResponse;
import club.mrxiao.baidu.response.BaiduTraceTrackAddPointsResponse;
import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BaiduTraceServiceTest {

    private final Log log = LogFactory.get(this.getClass().getName());

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
        try {
            BaiduTraceBaseResponse baiduTraceBaseResponse = service.getEntityService().entityAdd(entityRequest);
            log.info(JSON.toJSONString(baiduTraceBaseResponse));
        } catch (BaiduTraceException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void entityUpdate(){
        BaiduTraceService service = this.init();
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityDesc("test12345").entityName("test");
        try {
            BaiduTraceBaseResponse baiduTraceBaseResponse = service.getEntityService().entityUpdate(entityRequest);
            log.info(JSON.toJSONString(baiduTraceBaseResponse));
        } catch (BaiduTraceException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void entityDelete(){
        BaiduTraceService service = this.init();
        BaiduTraceEntityRequest entityRequest = new BaiduTraceEntityRequest();
        entityRequest.entityName("test");
        try {
            BaiduTraceBaseResponse baiduTraceBaseResponse = service.getEntityService().entityDelete(entityRequest);
            log.info(JSON.toJSONString(baiduTraceBaseResponse));
        } catch (BaiduTraceException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void entityList(){
        BaiduTraceService service = this.init();
        BaiduTraceCommonRequest baiduTraceCommonRequest = new BaiduTraceCommonRequest();
        baiduTraceCommonRequest.pageIndex(1).pageSize(2);
        try {
            BaiduTraceEntityListResponse baiduTraceEntityListResponse = service.getEntityService().entityList(baiduTraceCommonRequest);
            log.info(JSON.toJSONString(baiduTraceEntityListResponse));
        } catch (BaiduTraceException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void trackAddPoint(){
        BaiduTraceService service = this.init();
        BaiduTraceTrackPoint point = new BaiduTraceTrackPoint();

        point.setLocTime(DateUtil.currentSeconds());
        point.setLatitude(39.958219);
        point.setLongitude(116.496246);
        point.setCoordTypeInput("bd09ll");
        point.setEntityName("test");
        try {
            BaiduTraceBaseResponse baiduTraceBaseResponse = service.getTrackService().trackAddPoint(point);
            log.info(JSON.toJSONString(baiduTraceBaseResponse));
        } catch (BaiduTraceException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void trackAddPoints(){
        BaiduTraceService service = this.init();

        List<BaiduTraceTrackPoint> points = new ArrayList<BaiduTraceTrackPoint>();

        BaiduTraceTrackPoint point = new BaiduTraceTrackPoint();
        point.setLocTime(DateUtil.currentSeconds());
        point.setLatitude(39.95528);
        point.setLongitude(116.496363);
        point.setCoordTypeInput("bd09ll");
        point.setEntityName("test");
        points.add(point);

        BaiduTraceTrackPoint point2 = new BaiduTraceTrackPoint();
        point2.setLocTime(DateUtil.currentSeconds()+5);
        point2.setLatitude(39.952446);
        point2.setLongitude(116.496345);
        point2.setCoordTypeInput("bd09ll");
        point2.setEntityName("test");
        points.add(point2);

        BaiduTraceTrackPoint point3 = new BaiduTraceTrackPoint();
        point3.setLocTime(DateUtil.currentSeconds()+5);
        point3.setLatitude(39.949556);
        point3.setLongitude(116.496291);
        point3.setCoordTypeInput("bd09ll");
        point3.setEntityName("test");
        points.add(point3);
        try {
            BaiduTraceTrackAddPointsResponse baiduTraceTrackAddPointsResponse = service.getTrackService().trackAddPoints(points);
            log.info(JSON.toJSONString(baiduTraceTrackAddPointsResponse));
        } catch (BaiduTraceException e) {
            log.error(e.getMessage());
        }
    }
}
