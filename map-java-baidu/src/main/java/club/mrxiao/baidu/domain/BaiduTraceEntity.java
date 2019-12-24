package club.mrxiao.baidu.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 终端管理类
 * @author xiaoyu
 */
@Data
public class BaiduTraceEntity implements Serializable {

    private static final long serialVersionUID = -8505378214576433109L;

    /**
     * entity名称
     */
    @JSONField(name="entity_name")
    private String entityName;

    /**
     * 可读性描述
     */
    @JSONField(name="entity_desc")
    private String entityDesc;

    /**
     * entity属性修改时间
     */
    @JSONField(name="modify_time")
    private String modifyTime;

    /**
     * entity创建时间
     */
    @JSONField(name="create_time")
    private String createTime;

    /**
     * 最新的轨迹点信息
     */
    @JSONField(name="latest_location")
    private BaiduTraceTrackPoint latestLocation;
}
