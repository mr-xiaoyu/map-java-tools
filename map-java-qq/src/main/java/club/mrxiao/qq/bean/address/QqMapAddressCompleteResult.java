package club.mrxiao.qq.bean.address;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *  地址纠正补全服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2026-03-04
 */
@Data
public class QqMapAddressCompleteResult implements Serializable {

    private static final long serialVersionUID = 9072721533226274282L;

    /**
     * 行政区划代码
     */
    @JSONField(name="ad_code")
    private String adCode;

    /**
     * 省份-纠正补全信息
     */
    private CompleteInfo province;

    /**
     * 城市-纠正补全信息
     */
    private CompleteInfo city;

    /**
     * 区县-纠正补全信息
     */
    private CompleteInfo district;

    /**
     * 乡镇/街道-纠正补全信息
     */
    private CompleteInfo town;

    /**
     * 村庄-纠正补全信息
     */
    private CompleteInfo village;

    /**
     * 道路-纠正补全信息
     */
    private CompleteInfo road;

    /**
     * 道路-纠正补全信息
     */
    @JSONField(name="street_number")
    private CompleteInfo streetNumber;

    /**
     * 经过纠正补全处理后的地址
     */
    @JSONField(name="completed_address")
    private String completedAddress;


    /**
     * 门牌-纠正补全信息
     */
    @Data
    public static class CompleteInfo {

        /**
         * 纠正/补全名称
         */
        private String name;

        /**
         * 状态
         * <pre>
         * 取值为：
         * ORIGINAL 原始地址结果
         * FIXRESULT 纠正后结果
         * SUPRESULT 补全后结果
         * UNK 未知
         * </pre>
         */
        private String status;
    }

    public static QqMapAddressCompleteResult fromJson(String json){
        JSONObject object = JSON.parseObject(json);
        if (object.containsKey("result")){
            return JSON.toJavaObject(object.getJSONObject("result"),QqMapAddressCompleteResult.class);
        }
        return null;
    }
}
