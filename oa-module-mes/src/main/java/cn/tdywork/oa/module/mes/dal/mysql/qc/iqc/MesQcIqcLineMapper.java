package cn.tdywork.oa.module.mes.dal.mysql.qc.iqc;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.qc.iqc.vo.line.MesQcIqcLinePageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.qc.iqc.MesQcIqcLineDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MES 来料检验单行 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesQcIqcLineMapper extends BaseMapperX<MesQcIqcLineDO> {

    default PageResult<MesQcIqcLineDO> selectPage(MesQcIqcLinePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesQcIqcLineDO>()
                .eqIfPresent(MesQcIqcLineDO::getIqcId, reqVO.getIqcId())
                .orderByAsc(MesQcIqcLineDO::getId));
    }

    default List<MesQcIqcLineDO> selectListByIqcId(Long iqcId) {
        return selectList(MesQcIqcLineDO::getIqcId, iqcId);
    }

    default void deleteByIqcId(Long iqcId) {
        delete(new LambdaQueryWrapperX<MesQcIqcLineDO>()
                .eq(MesQcIqcLineDO::getIqcId, iqcId));
    }

    default Long selectCountByUnitMeasureId(Long unitMeasureId) {
        return selectCount(MesQcIqcLineDO::getUnitMeasureId, unitMeasureId);
    }

}
