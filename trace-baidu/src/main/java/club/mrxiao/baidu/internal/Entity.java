package club.mrxiao.baidu.internal;

import club.mrxiao.baidu.BaiduTraceClient;
import lombok.Data;

/**
 * 终端管理/空间搜索
 * @author xiaoyu
 */
@Data
public class Entity {

    private BaiduTraceClient baiduTraceClient;

    /**
     * 构造方法
     * @param baiduTraceClient 百度鹰眼
     */
    public Entity(BaiduTraceClient baiduTraceClient){
        this.baiduTraceClient = baiduTraceClient;
    }

    /**
     * 添加
     * @param entityName 终端名称
     */
    public void add(String entityName){

    }
}
