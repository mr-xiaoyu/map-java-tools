package club.mrxiao.qq.bean.address;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *  地址异常错误分析服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2026-03-04
 */
@Data
public class QqMapAbnormalAnalyResult implements Serializable {

    private static final long serialVersionUID = -7665035584701092823L;

    /**
     * 地址精细度
     */
    @JSONField(name="detail_level")
    private Integer detailLevel;

    /**
     * 地址完整度，对整条地址要素信息的完整情况进行打分
     */
    @JSONField(name="complete_level")
    private Integer completeLevel;

    /**
     * 是否存在异常， 0 正常 1 存在异常
     */
    private Integer abnormal;

    /**
     * 地址异常原因，若有多项异常，则数组会有多个返回值
     * <pre>
     *  取值范围如下：
     * “ADMIN_REPEAT” 区划冗余
     * “ADMIN_PCD_LACK” 省市区有缺失
     * “ADMIN_TOWN_LACK” 乡镇有缺失
     * “ADMIN_CONFLICT” 区划冲突，指区划上下级错配或不匹配
     * “STRUCT_LACK_ROAD_LEVEL” 缺少道路
     * “STRUCT_LACK_POI_LEVEL” 缺少 POI 或门牌
     * “STRUCT_LACK_ROOM_LEVEL” 地址不能精细到户
     * </pre>
     */
    private List<String> issues;

    public static QqMapAbnormalAnalyResult fromJson(String json){
        JSONObject object = JSON.parseObject(json);
        if (object.containsKey("result")){
            return JSON.toJavaObject(object.getJSONObject("result"),QqMapAbnormalAnalyResult.class);
        }
        return null;
    }
}
