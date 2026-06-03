package cn.tdywork.oa.module.iot.service.alert;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.common.util.object.BeanUtils;
import cn.tdywork.oa.module.iot.controller.admin.alert.vo.config.IotAlertConfigPageReqVO;
import cn.tdywork.oa.module.iot.controller.admin.alert.vo.config.IotAlertConfigSaveReqVO;
import cn.tdywork.oa.module.iot.dal.dataobject.alert.IotAlertConfigDO;
import cn.tdywork.oa.module.iot.dal.mysql.alert.IotAlertConfigMapper;
import cn.tdywork.oa.module.iot.service.rule.scene.IotSceneRuleService;
import cn.tdywork.oa.module.system.api.user.AdminUserApi;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.tdywork.oa.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.tdywork.oa.module.iot.enums.ErrorCodeConstants.ALERT_CONFIG_NOT_EXISTS;

/**
 * IoT 告警配置 Service 实现类
 *
 * @author 糖花源码
 */
@Service
@Validated
public class IotAlertConfigServiceImpl implements IotAlertConfigService {

    @Resource
    private IotAlertConfigMapper alertConfigMapper;

    @Resource
    @Lazy // 延迟，避免循环依赖报错
    private IotSceneRuleService sceneRuleService;

    @Resource
    private AdminUserApi adminUserApi;

    @Override
    public Long createAlertConfig(IotAlertConfigSaveReqVO createReqVO) {
        // 校验关联数据是否存在
        sceneRuleService.validateSceneRuleList(createReqVO.getSceneRuleIds());
        adminUserApi.validateUserList(createReqVO.getReceiveUserIds());

        // 插入
        IotAlertConfigDO alertConfig = BeanUtils.toBean(createReqVO, IotAlertConfigDO.class);
        alertConfigMapper.insert(alertConfig);
        return alertConfig.getId();
    }

    @Override
    public void updateAlertConfig(IotAlertConfigSaveReqVO updateReqVO) {
        // 校验存在
        validateAlertConfigExists(updateReqVO.getId());
        // 校验关联数据是否存在
        sceneRuleService.validateSceneRuleList(updateReqVO.getSceneRuleIds());
        adminUserApi.validateUserList(updateReqVO.getReceiveUserIds());

        // 更新
        IotAlertConfigDO updateObj = BeanUtils.toBean(updateReqVO, IotAlertConfigDO.class);
        alertConfigMapper.updateById(updateObj);
    }

    @Override
    public void deleteAlertConfig(Long id) {
        // 校验存在
        validateAlertConfigExists(id);
        // 删除
        alertConfigMapper.deleteById(id);
    }

    private void validateAlertConfigExists(Long id) {
        if (alertConfigMapper.selectById(id) == null) {
            throw exception(ALERT_CONFIG_NOT_EXISTS);
        }
    }

    @Override
    public IotAlertConfigDO getAlertConfig(Long id) {
        return alertConfigMapper.selectById(id);
    }

    @Override
    public PageResult<IotAlertConfigDO> getAlertConfigPage(IotAlertConfigPageReqVO pageReqVO) {
        return alertConfigMapper.selectPage(pageReqVO);
    }

    @Override
    public List<IotAlertConfigDO> getAlertConfigListByStatus(Integer status) {
        return alertConfigMapper.selectListByStatus(status);
    }

    @Override
    public List<IotAlertConfigDO> getAlertConfigListBySceneRuleIdAndStatus(Long sceneRuleId, Integer status) {
        return alertConfigMapper.selectListBySceneRuleIdAndStatus(sceneRuleId, status);
    }

}