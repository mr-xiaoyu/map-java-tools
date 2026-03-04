package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.Location;
import club.mrxiao.qq.bean.coord.QqMapCoordRequest;
import club.mrxiao.qq.bean.coord.QqMapCoordResult;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import test.ServiceFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QqMapCoordServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    String data = "116.34478369854806,39.82019227960702;116.34837692058797,39.66070733933229;116.44381289796802,39.69691466268769;116.57719330008955,39.75418529582079;116.51222784560794,39.829141690298;116.55563396785008,39.85373958684847;116.5547715945605,39.885637135111885;116.49584275310595,39.87035475881718;116.4690373166882,39.827340819735596";

    @Test
    public void translateTest() throws QqMapErrorException, InterruptedException {
        QqMapService service = ServiceFactory.getService();
        int processed = 0;
        int batchSize = 20;
        String[] ss = data.split(";");
        List<String> rs = new ArrayList<>();
        while (processed < ss.length) {
            int end = Math.min(processed + batchSize, ss.length);
            String[] batch = Arrays.copyOfRange(ss, processed, end);
            String[] ls = new String[batch.length];
            for (int i = 0; i < batch.length; i++) {
                String[] bs = batch[i].split(",");
                ls[i] = bs[1] + "," + bs[0];
            }

            QqMapCoordRequest request = QqMapCoordRequest.builder()
                .locations(StrUtil.join(";",ls))
                .type("3")
                .build();
            QqMapCoordResult result = service.getQqMapCoordService().translate(request);
            log.info("Translate result: \n{}", JSON.toJSONString(result));
            for (Location location : result.getLocations()) {

                rs.add(location.getLng()+","+location.getLat());
            }
            Thread.sleep(100);
            processed = end;
        }
        log.info("rr: \n{}",StrUtil.join(";",rs));
    }
}