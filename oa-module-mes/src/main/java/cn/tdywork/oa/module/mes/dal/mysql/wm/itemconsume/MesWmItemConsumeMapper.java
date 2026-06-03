package cn.tdywork.oa.module.mes.dal.mysql.wm.itemconsume;

import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.module.mes.dal.dataobject.wm.itemconsume.MesWmItemConsumeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MES 物料消耗记录 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesWmItemConsumeMapper extends BaseMapperX<MesWmItemConsumeDO> {

    default MesWmItemConsumeDO selectByFeedbackId(Long feedbackId) {
        return selectOne(MesWmItemConsumeDO::getFeedbackId, feedbackId);
    }

}
