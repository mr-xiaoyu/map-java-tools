package club.mrxiao.qq.bean.address;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *  地址真实性分析（地址验真）服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2026-03-04
 */
@Data
public class QqMapTruthAnalyResult implements Serializable {

    private static final long serialVersionUID = 5630954965904637213L;

    /**
     * 省市区验证
     */
    private TruthAnalyInfo pcd;

    /**
     * 乡镇街道验证
     */
    private List<TruthAnalyInfo> towns;

    /**
     * 村验证
     */
    private List<TruthAnalyInfo> villages;

    /**
     * 道路验证
     */
    private List<TruthAnalyInfo> roads;

    /**
     * 门牌号验证
     */
    @JSONField(name="street_nums")
    private List<TruthAnalyInfo> streetNums;

    /**
     * POI验证
     */
    private List<TruthAnalyInfo> pois;

    /**
     * 楼栋验证
     */
    private List<TruthAnalyInfo> buildings;

    /**
     * 乡镇结合POI验证
     */
    @JSONField(name="town_poi")
    private TruthAnalyInfo townPoi;

    /**
     * 道路结合POI验证
     */
    @JSONField(name="road_poi")
    private TruthAnalyInfo roadPoi;

    /**
     * 门牌结合POI验证
     */
    @JSONField(name="street_num_poi")
    private TruthAnalyInfo streetNumPoi;

    /**
     * 乡镇/街道结合村验证
     */
    @JSONField(name="town_village")
    private TruthAnalyInfo townVillage;

    /**
     * 整体得分
     */
    private TruthAnalyInfo overall;

    /**
     * 无关词信息
     */
    @JSONField(name="other_words")
    private Object otherWords;



    /**
     * 验证信息
     */
    @Data
    public static class TruthAnalyInfo {

        /**
         * 元素名称
         */
        @JSONField(name="ele_name")
        private String eleName;

        /**
         * 匹配元素名称
         */
        @JSONField(name="match_name")
        private String matchName;

        /**
         * 验真得分
         * <pre>
         * 取值范围:
         * -1 未知，无法判断地址真伪
         * 0~1 有验真结果，且数值越大越可信
         * UNK 未知
         * </pre>
         */
        private String score;

        /**
         * 元素名称
         */
        @JSONField(name="ele_com_name")
        private String eleComName;

        /**
         * 附属名称
         */
        @JSONField(name="atta_name")
        private String attaName;
    }

    public static QqMapTruthAnalyResult fromJson(String json){
        JSONObject object = JSON.parseObject(json);
        if (object.containsKey("result")){
            return JSON.toJavaObject(object.getJSONObject("result"),QqMapTruthAnalyResult.class);
        }
        return null;
    }
}
