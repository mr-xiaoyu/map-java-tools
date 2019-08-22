package club.mrxiao.baidu.request;

import java.util.HashMap;

/**
 * 终端管理类
 * @author xiaoyu
 */
public class BaiduTraceEntityRequest extends HashMap<String, Object> {

    @Override
    public BaiduTraceEntityRequest put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 设置entity名称
     * @param entityName entity名称
     * @return
     */
    public BaiduTraceEntityRequest entityName(String entityName){
        this.put("entity_name",entityName);
        return this;
    }

    /**
     * 设置entity 的可读性描述
     * @param setentityDesc entity 的可读性描述
     * @return
     */
    public BaiduTraceEntityRequest entityDesc(String setentityDesc){
        this.put("entity_desc",setentityDesc);
        return this;
    }
}
