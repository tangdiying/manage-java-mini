package cn.tdywork.oa.module.pay.convert.wallet;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.module.pay.controller.admin.wallet.vo.transaction.PayWalletTransactionRespVO;
import cn.tdywork.oa.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import cn.tdywork.oa.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import cn.tdywork.oa.module.pay.service.wallet.bo.WalletTransactionCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<PayWalletTransactionRespVO> convertPage2(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(WalletTransactionCreateReqBO bean);

}
