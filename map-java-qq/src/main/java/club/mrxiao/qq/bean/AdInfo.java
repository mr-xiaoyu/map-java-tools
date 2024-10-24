package club.mrxiao.qq.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 *  <pre>
 *      腾讯地图行政区划信息对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
public class AdInfo  implements Serializable {

    private static final long serialVersionUID = -4280959392490239728L;

    /**
     * 行政区划代码
     */
    private int adcode;

    /**
     * 省
     */
    private String province;

    /**
     * 市，如果当前城市为省直辖县级区划，此字段会返回为空，由district字段返回。
     * 注：省直辖县级区划adcode第3和第4位分别为9、0，如济源市adcode为419001
     */
    private String city;

    /**
     * 区，可能为空字串
     */
    private String district;

    /**
     * 街道/道路，可能为空字串
     */
    private String street;

    /**
     * 门牌，可能为空字串
     */
    @JSONField(name="street_number")
    private String streetNumber;

}
