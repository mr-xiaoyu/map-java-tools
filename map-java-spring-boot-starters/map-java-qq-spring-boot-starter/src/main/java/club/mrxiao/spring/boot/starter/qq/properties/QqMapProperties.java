package club.mrxiao.spring.boot.starter.qq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类.
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-15
 */
@Data
@ConfigurationProperties(prefix = "xytool.map.qq")
public class QqMapProperties {

    /**
     * 接口key
     */
    private String key;
}
