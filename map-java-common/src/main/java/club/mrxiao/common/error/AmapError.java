package club.mrxiao.common.error;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      高德地图错误码
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-08
 */
@Data
@Builder
@AllArgsConstructor
public class AmapError implements Serializable {

    private static final long serialVersionUID = -8070962870328374262L;

    /**
     * 返回结果状态值
     */
    private String status;

    /**
     * infocode
     */
    private String infocode;

    /**
     * 返回状态说明
     */
    private String info;

    /**
     * 原始数据
     */
    private String json;


    public static AmapError fromJson(String json) {
        if(StrUtil.isBlank(json)){
            return AmapError.builder().status("0").info("无响应").build();
        }
        JSONObject object = JSONObject.parseObject(json);
        AmapError error = object.toJavaObject(AmapError.class);
        error.setJson(object.toJSONString());
        return error;
    }

    @Override
    public String toString() {
        if (this.json == null) {
            return "状态代码：" + this.status + ", 错误信息：" + this.info;
        }
        return "状态代码：" + this.status + "，错误代码：" + this.infocode + ", 错误信息：" + this.info + "，原始报文：" + this.json;
    }
}
