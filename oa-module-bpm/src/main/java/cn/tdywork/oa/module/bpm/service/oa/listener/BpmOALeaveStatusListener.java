package cn.tdywork.oa.module.bpm.service.oa.listener;

import cn.tdywork.oa.module.bpm.api.event.BpmProcessInstanceStatusEvent;
import cn.tdywork.oa.module.bpm.api.event.BpmProcessInstanceStatusEventListener;
import cn.tdywork.oa.module.bpm.service.oa.BpmOALeaveService;
import cn.tdywork.oa.module.bpm.service.oa.BpmOALeaveServiceImpl;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * OA 请假单的结果的监听器实现类
 *
 * @author 糖花源码
 */
@Component
public class BpmOALeaveStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private BpmOALeaveService leaveService;

    @Override
    protected String getProcessDefinitionKey() {
        return BpmOALeaveServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceStatusEvent event) {
        leaveService.updateLeaveStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
