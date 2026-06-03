package cn.tdywork.oa.module.mes.dal.mysql.wm.productproduce;

import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.module.mes.dal.dataobject.wm.productproduce.MesWmProductProduceDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MES 生产入库单 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesWmProductProduceMapper extends BaseMapperX<MesWmProductProduceDO> {

    default MesWmProductProduceDO selectByFeedbackId(Long feedbackId) {
        return selectOne(MesWmProductProduceDO::getFeedbackId, feedbackId);
    }

}
