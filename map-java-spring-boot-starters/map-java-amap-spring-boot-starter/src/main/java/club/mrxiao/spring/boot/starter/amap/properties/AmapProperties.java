package club.mrxiao.spring.boot.starter.amap.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类.
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2022-08-08
 */
@Data
@ConfigurationProperties(prefix = "xytool.map.amap")
public class AmapProperties {

    /**
     * key
     */
    private String key;
}
