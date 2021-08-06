package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.packetevents.translate.PacketEventsTranslators;
import org.fairy.packet.mcp.PlayerAction;
import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketEntityAction;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.entityaction.WrappedPacketInEntityAction;

public class CPacketEventsEntityAction extends PacketEventWrapper<WrappedPacketInEntityAction> implements CPacketEntityAction {
    public CPacketEventsEntityAction(WrappedPacketInEntityAction wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public PlayerAction getAction() {
        final WrappedPacketInEntityAction.PlayerAction bridge = wrapper.getAction();
        return bridge == null ? null : PacketEventsTranslators.PLAYER_ACTION.transform(bridge);
    }
}
