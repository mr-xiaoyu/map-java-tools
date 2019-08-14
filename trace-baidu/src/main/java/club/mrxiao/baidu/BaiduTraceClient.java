package club.mrxiao.baidu;

import club.mrxiao.baidu.internal.Entity;
import lombok.Data;

/**
 * 百度鹰眼
 * @author xiaoyu
 */
@Data
public class BaiduTraceClient {
    /**
     * 	百度用户的AK
     */
    private String ak;
    /**
     * service的ID，service 的唯一标识
     */
    private Integer serviceId;

    /**
     * 终端管理/空间搜索
     */
    private Entity entity;

    /**
     * 构造
     * @param ak 百度用户的AK
     * @param serviceId service的ID
     */
    public BaiduTraceClient(String ak,Integer serviceId){
        this.ak = ak;
        this.serviceId = serviceId;

        this.entity = new Entity(this);
    }


}
