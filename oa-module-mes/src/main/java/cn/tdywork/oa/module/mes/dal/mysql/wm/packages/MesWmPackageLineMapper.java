package cn.tdywork.oa.module.mes.dal.mysql.wm.packages;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.wm.packages.vo.line.MesWmPackageLinePageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.wm.packages.MesWmPackageLineDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MES 装箱明细 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesWmPackageLineMapper extends BaseMapperX<MesWmPackageLineDO> {

    default PageResult<MesWmPackageLineDO> selectPage(MesWmPackageLinePageReqVO reqVO, java.util.Collection<Long> packageIds) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesWmPackageLineDO>()
                .inIfPresent(MesWmPackageLineDO::getPackageId, packageIds)
                .orderByDesc(MesWmPackageLineDO::getId));
    }

    default void deleteByPackageId(Long packageId) {
        delete(MesWmPackageLineDO::getPackageId, packageId);
    }

}
