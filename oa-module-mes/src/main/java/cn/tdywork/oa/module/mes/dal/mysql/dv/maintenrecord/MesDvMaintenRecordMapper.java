package cn.tdywork.oa.module.mes.dal.mysql.dv.maintenrecord;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.dv.maintenrecord.vo.MesDvMaintenRecordPageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.dv.maintenrecord.MesDvMaintenRecordDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MES 设备保养记录 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesDvMaintenRecordMapper extends BaseMapperX<MesDvMaintenRecordDO> {

    default PageResult<MesDvMaintenRecordDO> selectPage(MesDvMaintenRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesDvMaintenRecordDO>()
                .eqIfPresent(MesDvMaintenRecordDO::getPlanId, reqVO.getPlanId())
                .eqIfPresent(MesDvMaintenRecordDO::getMachineryId, reqVO.getMachineryId())
                .eqIfPresent(MesDvMaintenRecordDO::getUserId, reqVO.getUserId())
                .betweenIfPresent(MesDvMaintenRecordDO::getMaintenTime, reqVO.getMaintenTime())
                .orderByDesc(MesDvMaintenRecordDO::getId));
    }

    default Long selectCountByMachineryId(Long machineryId) {
        return selectCount(MesDvMaintenRecordDO::getMachineryId, machineryId);
    }

}
