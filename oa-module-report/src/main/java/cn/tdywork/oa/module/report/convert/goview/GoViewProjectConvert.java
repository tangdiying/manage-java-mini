package cn.tdywork.oa.module.report.convert.goview;

import cn.tdywork.oa.framework.common.pojo.PageResult;
import cn.tdywork.oa.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import cn.tdywork.oa.module.report.controller.admin.goview.vo.project.GoViewProjectRespVO;
import cn.tdywork.oa.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import cn.tdywork.oa.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoViewProjectConvert {

    GoViewProjectConvert INSTANCE = Mappers.getMapper(GoViewProjectConvert.class);

    GoViewProjectDO convert(GoViewProjectCreateReqVO bean);

    GoViewProjectDO convert(GoViewProjectUpdateReqVO bean);

    GoViewProjectRespVO convert(GoViewProjectDO bean);

    PageResult<GoViewProjectRespVO> convertPage(PageResult<GoViewProjectDO> page);

}
