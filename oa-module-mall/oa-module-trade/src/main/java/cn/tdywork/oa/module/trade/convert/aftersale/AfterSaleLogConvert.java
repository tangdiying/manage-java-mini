package cn.tdywork.oa.module.trade.convert.aftersale;

import cn.tdywork.oa.module.trade.dal.dataobject.aftersale.AfterSaleLogDO;
import cn.tdywork.oa.module.trade.service.aftersale.bo.AfterSaleLogCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AfterSaleLogConvert {

    AfterSaleLogConvert INSTANCE = Mappers.getMapper(AfterSaleLogConvert.class);

    AfterSaleLogDO convert(AfterSaleLogCreateReqBO bean);

}
