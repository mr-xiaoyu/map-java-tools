package club.mrxiao.spring.boot.starter.baidu.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类.
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Data
@ConfigurationProperties(prefix = "xytool.map.baidu")
public class BaiduMapProperties {

    /**
     * 接口ak
     */
    private String ak;
}
