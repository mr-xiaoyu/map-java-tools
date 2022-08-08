package club.mrxiao.spring.boot.starter.baidu.config;

import club.mrxiao.baidu.api.BaiduMapService;
import club.mrxiao.baidu.api.impl.BaiduMapServiceImpl;
import club.mrxiao.baidu.config.BaiduMapConfig;
import club.mrxiao.spring.boot.starter.baidu.properties.BaiduMapProperties;
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
@ConditionalOnClass(BaiduMapService.class)
@EnableConfigurationProperties(BaiduMapProperties.class)
@ConditionalOnProperty(prefix = "xytool.map.baidu", name = "enabled", matchIfMissing = true)
public class BaiduMapAutoConfiguration {

    private final BaiduMapProperties properties;

    @Bean
    @ConditionalOnMissingBean(BaiduMapService.class)
    public BaiduMapService baiduMapService() {
        BaiduMapConfig config = new BaiduMapConfig();
        config.setAk(properties.getAk());
        final BaiduMapService service = new BaiduMapServiceImpl();
        service.setBaiduMapConfig(config);
        return service;
    }
}
