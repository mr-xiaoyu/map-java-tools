package club.mrxiao.baidu.request;

import java.util.HashMap;

/**
 * 百度鹰眼通用查询参数
 * @author xiaoyu
 */
public class BaiduTraceCommonRequest extends HashMap<String, Object> {

    private static final long serialVersionUID = 5962324515792193982L;

    @Override
    public BaiduTraceCommonRequest put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 分页索引
     * @param pageIndex
     * @return
     */
    public BaiduTraceCommonRequest pageIndex(Integer pageIndex){
        this.put("page_index",pageIndex);
        return this;
    }

    /**
     * 分页大小
     * @param pageSize
     * @return
     */
    public BaiduTraceCommonRequest pageSize(Integer pageSize){
        this.put("page_size",pageSize);
        return this;
    }

    /**
     * 过滤条件
     * @param filter
     * @return
     */
    public BaiduTraceCommonRequest filter(String filter){
        this.put("filter",filter);
        return this;
    }

    /**
     * 返回结果的坐标类型
     * @param coordTypeOutput
     * @return
     */
    public BaiduTraceCommonRequest coordTypeOutput(String coordTypeOutput){
        this.put("coord_type_output",coordTypeOutput);
        return this;
    }


}
