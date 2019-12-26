package club.mrxiao.common.error;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      百度地图错误码
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
@Builder
@AllArgsConstructor
public class BaiduMapError implements Serializable {

    private static final long serialVersionUID = -7233779636328730018L;

    /**
     * API访问状态
     */
    private int status;

    /**
     * 说明
     */
    private String message;

    /**
     * 原始数据
     */
    private String json;

    public static BaiduMapError fromJson(String json) {
        if(StrUtil.isBlank(json)){
            return BaiduMapError.builder().status(-1).message("无响应").build();
        }
        JSONObject object = JSONObject.parseObject(json);
        BaiduMapError error = object.toJavaObject(BaiduMapError.class);
        error.setJson(object.toJSONString());
        return error;
    }

    @Override
    public String toString() {
        if (this.json == null) {
            return "错误代码：" + this.status + ", 错误信息：" + this.message;
        }
        return "错误代码：" + this.status + ", 错误信息：" + this.message + "，原始报文：" + this.json;
    }
}
