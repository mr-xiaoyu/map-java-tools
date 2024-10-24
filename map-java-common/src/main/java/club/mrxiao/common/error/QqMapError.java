package club.mrxiao.common.error;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  腾讯地图错误码
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
@Builder
@AllArgsConstructor
public class QqMapError implements Serializable {

    private static final long serialVersionUID = 1086454783593392619L;

    /**
     * 状态码，0为正常，其它为异常
     */
    private int status;

    /**
     * 状态说明
     */
    private String message;

    /**
     * 本次请求的唯一标识，由系统自动生成，用于追查结果有异常时使用
     */
    @JSONField(name="request_id")
    private String requestId;

    /**
     * 原始数据
     */
    private String json;


    public static QqMapError fromJson(String json) {
        if(StrUtil.isBlank(json)){
            return QqMapError.builder().status(-1).message("无响应").build();
        }
        JSONObject object = JSONObject.parseObject(json);
        QqMapError error = object.toJavaObject(QqMapError.class);
        error.setJson(object.toJSONString());
        return error;
    }

    @Override
    public String toString() {
        if (this.json == null) {
            return "状态代码：" + this.status + ", 错误信息：" + this.message;
        }
        return "状态代码：" + this.status + ", 错误信息：" + this.message + "，原始报文：" + this.json;
    }
}
