package cn.tdywork.oa.module.iot.gateway.protocol.modbus.tcpserver.handler.downstream;

import cn.tdywork.oa.module.iot.core.messagebus.core.IotMessageBus;
import cn.tdywork.oa.module.iot.core.mq.message.IotDeviceMessage;
import cn.tdywork.oa.module.iot.gateway.protocol.AbstractIotProtocolDownstreamSubscriber;
import cn.tdywork.oa.module.iot.gateway.protocol.modbus.tcpserver.IotModbusTcpServerProtocol;
import lombok.extern.slf4j.Slf4j;

/**
 * IoT Modbus TCP Server 下行消息订阅器：订阅消息总线的下行消息并转发给处理器
 *
 * @author 糖花源码
 */
@Slf4j
public class IotModbusTcpServerDownstreamSubscriber extends AbstractIotProtocolDownstreamSubscriber {

    private final IotModbusTcpServerDownstreamHandler downstreamHandler;

    public IotModbusTcpServerDownstreamSubscriber(IotModbusTcpServerProtocol protocol,
                                                  IotModbusTcpServerDownstreamHandler downstreamHandler,
                                                  IotMessageBus messageBus) {
        super(protocol, messageBus);
        this.downstreamHandler = downstreamHandler;
    }

    @Override
    protected void handleMessage(IotDeviceMessage message) {
        downstreamHandler.handle(message);
    }

}
