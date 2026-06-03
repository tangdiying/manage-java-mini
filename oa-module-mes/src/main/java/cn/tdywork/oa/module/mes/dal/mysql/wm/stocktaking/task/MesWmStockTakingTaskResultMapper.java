package cn.tdywork.oa.module.mes.dal.mysql.wm.stocktaking.task;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.wm.stocktaking.task.vo.result.MesWmStockTakingTaskResultPageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.wm.stocktaking.task.MesWmStockTakingTaskResultDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MES 盘点结果 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesWmStockTakingTaskResultMapper extends BaseMapperX<MesWmStockTakingTaskResultDO> {

    default PageResult<MesWmStockTakingTaskResultDO> selectPage(MesWmStockTakingTaskResultPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesWmStockTakingTaskResultDO>()
                .eqIfPresent(MesWmStockTakingTaskResultDO::getTaskId, reqVO.getTaskId())
                .eqIfPresent(MesWmStockTakingTaskResultDO::getItemId, reqVO.getItemId())
                .eqIfPresent(MesWmStockTakingTaskResultDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(MesWmStockTakingTaskResultDO::getLocationId, reqVO.getLocationId())
                .eqIfPresent(MesWmStockTakingTaskResultDO::getAreaId, reqVO.getAreaId())
                .orderByDesc(MesWmStockTakingTaskResultDO::getId));
    }

    default void deleteByTaskId(Long taskId) {
        delete(MesWmStockTakingTaskResultDO::getTaskId, taskId);
    }

}
