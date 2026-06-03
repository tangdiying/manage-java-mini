package cn.tdywork.oa.module.mp.convert.message;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.module.mp.controller.admin.message.vo.autoreply.MpAutoReplyCreateReqVO;
import cn.tdywork.oa.module.mp.controller.admin.message.vo.autoreply.MpAutoReplyRespVO;
import cn.tdywork.oa.module.mp.controller.admin.message.vo.autoreply.MpAutoReplyUpdateReqVO;
import cn.tdywork.oa.module.mp.dal.dataobject.message.MpAutoReplyDO;
import cn.tdywork.oa.module.mp.service.message.bo.MpMessageSendOutReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MpAutoReplyConvert {

    MpAutoReplyConvert INSTANCE = Mappers.getMapper(MpAutoReplyConvert.class);

    @Mappings({
            @Mapping(source = "reply.appId", target = "appId"),
            @Mapping(source = "reply.responseMessageType", target = "type"),
            @Mapping(source = "reply.responseContent", target = "content"),
            @Mapping(source = "reply.responseMediaId", target = "mediaId"),
            @Mapping(source = "reply.responseTitle", target = "title"),
            @Mapping(source = "reply.responseDescription", target = "description"),
            @Mapping(source = "reply.responseArticles", target = "articles"),
    })
    MpMessageSendOutReqBO convert(String openid, MpAutoReplyDO reply);

    PageResult<MpAutoReplyRespVO> convertPage(PageResult<MpAutoReplyDO> page);

    MpAutoReplyRespVO convert(MpAutoReplyDO bean);

    MpAutoReplyDO convert(MpAutoReplyCreateReqVO bean);

    MpAutoReplyDO convert(MpAutoReplyUpdateReqVO bean);
}
