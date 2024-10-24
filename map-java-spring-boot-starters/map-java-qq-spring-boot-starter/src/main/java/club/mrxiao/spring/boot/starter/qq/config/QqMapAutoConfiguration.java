package club.mrxiao.spring.boot.starter.qq.config;

import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.api.impl.QqMapServiceImpl;
import club.mrxiao.qq.config.QqMapConfig;
import club.mrxiao.spring.boot.starter.qq.properties.QqMapProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置.
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-15
 */
@Configuration
@AllArgsConstructor
@ConditionalOnClass(QqMapService.class)
@EnableConfigurationProperties(QqMapProperties.class)
@ConditionalOnProperty(prefix = "xytool.map.qq", name = "enabled", matchIfMissing = true)
public class QqMapAutoConfiguration {

    private final QqMapProperties properties;

    @Bean
    @ConditionalOnMissingBean(QqMapService.class)
    public QqMapService qqMapService() {
        QqMapConfig config = new QqMapConfig();
        config.setKey(properties.getKey());
        final QqMapService service = new QqMapServiceImpl();
        service.setQqMapConfig(config);
        return service;
    }
}
