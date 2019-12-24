package club.mrxiao.baidu.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 上传失败的点信息
 * @author xioayu
 */
@Data
public class BaiduTraceFailInfo {

    /**
     * 输入参数不正确导致的上传失败的点
     */
    @JSONField(name="param_error")
    private List<BaiduTraceTrackPoint> paramError;

    /**
     * 服务器内部错误导致上传失败的点
     */
    @JSONField(name="internal_error")
    private List<BaiduTraceTrackPoint> internalError;
}
