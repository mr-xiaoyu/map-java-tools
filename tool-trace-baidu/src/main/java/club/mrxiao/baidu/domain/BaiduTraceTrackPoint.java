package club.mrxiao.baidu.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * 轨迹点信息
 * @author xiaoyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaiduTraceTrackPoint extends BaiduTracePoint{
    /**
     * 对象数据名称
     */
    @JSONField(name="object_name")
    private String objectName;

    /**
     * track自定义字段
     */
    private Map<String, String> columns;
}
