package club.mrxiao.amap.api.impl;


import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.test.ServiceFactory;
import club.mrxiao.amap.bean.district.AmapDistrictRequest;
import club.mrxiao.amap.bean.district.AmapDistrictResult;
import club.mrxiao.common.error.AmapErrorException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class AmapDistrictServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void query() throws AmapErrorException {
        AmapService service = ServiceFactory.getAmapService();
        AmapDistrictRequest request = AmapDistrictRequest.builder()
                .keywords("北京市")
                .filter("110000")
                .subdistrict("3")
                .build();
        List<AmapDistrictResult> result = service.getAmapDistrictService().query(request);
        log.info("\n【result】: \n{}", JSON.toJSONString(result));
    }
}