package cn.tdywork.oa.module.mes.dal.mysql.tm.tool;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.tm.tool.vo.MesTmToolPageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.tm.tool.MesTmToolDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * MES 工具台账 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface MesTmToolMapper extends BaseMapperX<MesTmToolDO> {

    default PageResult<MesTmToolDO> selectPage(MesTmToolPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesTmToolDO>()
                .likeIfPresent(MesTmToolDO::getCode, reqVO.getCode())
                .likeIfPresent(MesTmToolDO::getName, reqVO.getName())
                .eqIfPresent(MesTmToolDO::getToolTypeId, reqVO.getToolTypeId())
                .likeIfPresent(MesTmToolDO::getBrand, reqVO.getBrand())
                .likeIfPresent(MesTmToolDO::getSpecification, reqVO.getSpecification())
                .eqIfPresent(MesTmToolDO::getStatus, reqVO.getStatus())
                .orderByDesc(MesTmToolDO::getId));
    }

    default MesTmToolDO selectByCode(String code) {
        return selectOne(MesTmToolDO::getCode, code);
    }

    default Long selectCountByToolTypeId(Long toolTypeId) {
        return selectCount(MesTmToolDO::getToolTypeId, toolTypeId);
    }

}
