package cn.tdywork.oa.module.mes.dal.mysql.wm.productissue;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.mes.controller.admin.wm.productissue.vo.line.MesWmProductIssueLinePageReqVO;
import cn.tdywork.oa.module.mes.dal.dataobject.wm.productissue.MesWmProductIssueLineDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MES 领料出库单行 Mapper
 */
@Mapper
public interface MesWmProductIssueLineMapper extends BaseMapperX<MesWmProductIssueLineDO> {

    default PageResult<MesWmProductIssueLineDO> selectPage(MesWmProductIssueLinePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MesWmProductIssueLineDO>()
                .eqIfPresent(MesWmProductIssueLineDO::getIssueId, reqVO.getIssueId())
                .orderByDesc(MesWmProductIssueLineDO::getId));
    }

    default List<MesWmProductIssueLineDO> selectListByIssueId(Long issueId) {
        return selectList(MesWmProductIssueLineDO::getIssueId, issueId);
    }

    default void deleteByIssueId(Long issueId) {
        delete(MesWmProductIssueLineDO::getIssueId, issueId);
    }

}
