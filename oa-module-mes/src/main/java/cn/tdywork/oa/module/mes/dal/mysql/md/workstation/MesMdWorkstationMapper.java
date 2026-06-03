package cn.tdywork.oa.module.mes.dal.mysql.md.workstation;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.md.workstation.vo.MesMdWorkstationPageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.md.workstation.MesMdWorkstationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MES 工作站 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesMdWorkstationMapper extends BaseMapperX<MesMdWorkstationDO> {

    default PageResult<MesMdWorkstationDO> selectPage(MesMdWorkstationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesMdWorkstationDO>()
                .eqIfPresent(MesMdWorkstationDO::getCode, reqVO.getCode())
                .likeIfPresent(MesMdWorkstationDO::getName, reqVO.getName())
                .eqIfPresent(MesMdWorkstationDO::getWorkshopId, reqVO.getWorkshopId())
                .eqIfPresent(MesMdWorkstationDO::getProcessId, reqVO.getProcessId())
                .eqIfPresent(MesMdWorkstationDO::getStatus, reqVO.getStatus())
                .orderByDesc(MesMdWorkstationDO::getId));
    }

    default MesMdWorkstationDO selectByCode(String code) {
        return selectOne(MesMdWorkstationDO::getCode, code);
    }

    default MesMdWorkstationDO selectByName(String name) {
        return selectOne(MesMdWorkstationDO::getName, name);
    }

    default List<MesMdWorkstationDO> selectListByStatus(Integer status) {
        return selectList(MesMdWorkstationDO::getStatus, status);
    }

    default Long selectCountByWorkshopId(Long workshopId) {
        return selectCount(MesMdWorkstationDO::getWorkshopId, workshopId);
    }

    default Long selectCountByWarehouseId(Long warehouseId) {
        return selectCount(MesMdWorkstationDO::getWarehouseId, warehouseId);
    }

    default Long selectCountByLocationId(Long locationId) {
        return selectCount(MesMdWorkstationDO::getLocationId, locationId);
    }

    default Long selectCountByAreaId(Long areaId) {
        return selectCount(MesMdWorkstationDO::getAreaId, areaId);
    }

}
