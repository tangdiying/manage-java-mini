package cn.tdywork.oa.module.erp.dal.mysql.finance;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.module.erp.controller.admin.finance.vo.account.ErpAccountPageReqVO;
import cn.tdywork.oa.module.erp.dal.dataobject.finance.ErpAccountDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 结算账户 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface ErpAccountMapper extends BaseMapperX<ErpAccountDO> {

    default PageResult<ErpAccountDO> selectPage(ErpAccountPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpAccountDO>()
                .likeIfPresent(ErpAccountDO::getName, reqVO.getName())
                .likeIfPresent(ErpAccountDO::getNo, reqVO.getNo())
                .eqIfPresent(ErpAccountDO::getRemark, reqVO.getRemark())
                .orderByDesc(ErpAccountDO::getId));
    }

    default ErpAccountDO selectByDefaultStatus() {
        return selectOne(ErpAccountDO::getDefaultStatus, true);
    }

    default List<ErpAccountDO> selectListByStatus(Integer status) {
        return selectList(ErpAccountDO::getStatus, status);
    }

}