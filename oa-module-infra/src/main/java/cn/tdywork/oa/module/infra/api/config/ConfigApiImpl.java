package cn.tdywork.oa.module.infra.api.config;

import cn.tdywork.oa.module.infra.dal.dataobject.config.ConfigDO;
import cn.tdywork.oa.module.infra.service.config.ConfigService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 参数配置 API 实现类
 *
 * @author 糖花源码
 */
@Service
@Validated
public class ConfigApiImpl implements ConfigApi {

    @Resource
    private ConfigService configService;

    @Override
    public String getConfigValueByKey(String key) {
        ConfigDO config = configService.getConfigByKey(key);
        return config != null ? config.getValue() : null;
    }

}
