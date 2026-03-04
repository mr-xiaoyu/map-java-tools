package club.mrxiao.qq.api.impl;

import club.mrxiao.qq.api.QqMapService;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import test.ServiceFactory;

import static org.junit.Assert.*;

public class QqMapServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Test
    public void getQqMapConfig() {
        QqMapService service = ServiceFactory.getService();
        log.info("config: \n{}", JSON.toJSONString(service.getQqMapConfig()));
    }
}