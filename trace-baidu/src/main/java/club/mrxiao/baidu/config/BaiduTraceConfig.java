package club.mrxiao.baidu.config;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 百度鹰眼配置
 * @author xiaoyu
 */
@Data
public class BaiduTraceConfig {

    /**
     *  用户的AK
     */
    private String ak;

    /**
     *  service的ID
     */
    private Integer serviceId;

    private Map<String,Object> baseRequest;

    public BaiduTraceConfig(String ak,Integer serviceId){
        this.ak = ak;
        this.serviceId = serviceId;
        this.baseRequest = new HashMap<String, Object>(3);
        baseRequest.put("ak",ak);
        baseRequest.put("service_id",serviceId);
    }
}
