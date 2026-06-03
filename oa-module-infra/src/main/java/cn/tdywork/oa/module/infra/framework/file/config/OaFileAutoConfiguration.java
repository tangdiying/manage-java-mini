package cn.tdywork.oa.module.infra.framework.file.config;

import cn.tdywork.oa.module.infra.framework.file.core.client.FileClientFactory;
import cn.tdywork.oa.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author 糖花源码
 */
@Configuration(proxyBeanMethods = false)
public class OaFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
