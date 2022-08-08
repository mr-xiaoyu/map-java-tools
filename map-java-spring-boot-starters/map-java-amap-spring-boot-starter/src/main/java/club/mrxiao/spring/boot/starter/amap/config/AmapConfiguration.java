package club.mrxiao.spring.boot.starter.amap.config;

import club.mrxiao.amap.api.AmapService;
import club.mrxiao.amap.api.impl.AmapServiceImpl;
import club.mrxiao.amap.config.AmapConfig;
import club.mrxiao.spring.boot.starter.amap.properties.AmapProperties;
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
 * @since 2019-12-26
 */
@Configuration
@AllArgsConstructor
@ConditionalOnClass(AmapService.class)
@EnableConfigurationProperties(AmapProperties.class)
@ConditionalOnProperty(prefix = "xytool.map.amap", name = "enabled", matchIfMissing = true)
public class AmapConfiguration {

    private final AmapProperties properties;

    @Bean
    @ConditionalOnMissingBean(AmapService.class)
    public AmapService amapService() {
        AmapConfig config = new AmapConfig();
        config.setKey(properties.getKey());
        final AmapService service = new AmapServiceImpl();
        service.setAmapConfig(config);
        return service;
    }
}
