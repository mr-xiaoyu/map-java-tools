package club.mrxiao.amap;

import lombok.Data;

/**
 * 高德猎鹰
 * @author xiaoyu
 */
@Data
public class AmapTraceClient {

    /**
     * key
     */
    private String key;

    /**
     * 服务的唯一编号
     */
    private Integer sid;

    /**
     * 构造方法
     * @param key key
     * @param sid 服务的唯一编号
     */
    public AmapTraceClient(String key,Integer sid){
        this.key = key;
        this.sid = sid;
    }
}
