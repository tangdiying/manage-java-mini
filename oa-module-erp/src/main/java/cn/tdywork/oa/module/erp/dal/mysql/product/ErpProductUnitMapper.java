package cn.tdywork.oa.module.erp.dal.mysql.product;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tdywork.oa.framework.mybatis.core.mapper.BaseMapperX;
import cn.tdywork.oa.module.erp.controller.admin.product.vo.unit.ErpProductUnitPageReqVO;
import cn.tdywork.oa.module.erp.dal.dataobject.product.ErpProductUnitDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 产品单位 Mapper
 *
 * @author 糖花源码
 */
@Mapper
public interface ErpProductUnitMapper extends BaseMapperX<ErpProductUnitDO> {

    default PageResult<ErpProductUnitDO> selectPage(ErpProductUnitPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpProductUnitDO>()
                .likeIfPresent(ErpProductUnitDO::getName, reqVO.getName())
                .eqIfPresent(ErpProductUnitDO::getStatus, reqVO.getStatus())
                .orderByDesc(ErpProductUnitDO::getId));
    }

    default ErpProductUnitDO selectByName(String name) {
        return selectOne(ErpProductUnitDO::getName, name);
    }

    default List<ErpProductUnitDO> selectListByStatus(Integer status) {
        return selectList(ErpProductUnitDO::getStatus, status);
    }

}