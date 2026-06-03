package cn.tdywork.oa.module.member.framework.web.config;

import cn.tdywork.oa.framework.swagger.config.OaSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * member 模块的 web 组件的 Configuration
 *
 * @author 糖花源码
 */
@Configuration(proxyBeanMethods = false)
public class MemberWebConfiguration {

    /**
     * member 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi memberGroupedOpenApi() {
        return OaSwaggerAutoConfiguration.buildGroupedOpenApi("member");
    }

}
