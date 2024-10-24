package club.mrxiao.qq.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  <pre>
 *      腾讯地图坐标对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
@Data
public class Location implements Serializable {

    private static final long serialVersionUID = 7429757692452020660L;

    /**
     * 纬度
     */
    private BigDecimal lat;

    /**
     * 经度
     */
    private BigDecimal lng;
}
