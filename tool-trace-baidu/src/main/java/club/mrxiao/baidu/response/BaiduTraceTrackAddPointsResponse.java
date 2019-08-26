package club.mrxiao.baidu.response;

import club.mrxiao.baidu.domain.BaiduTraceFailInfo;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 批量添加轨迹点
 * @author xiaoyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaiduTraceTrackAddPointsResponse extends BaiduTraceBaseResponse{

    /**
     * 上传成功的点个数
     */
    @JSONField(name="success_num")
    private Integer successNum;

    /**
     * 	上传失败的点信息
     */
    @JSONField(name="fail_info")
    private BaiduTraceFailInfo failInfo;
}
