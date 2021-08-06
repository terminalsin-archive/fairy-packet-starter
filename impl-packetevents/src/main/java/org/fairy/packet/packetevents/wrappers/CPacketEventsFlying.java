package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketFlying;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;

public class CPacketEventsFlying extends PacketEventWrapper<WrappedPacketInFlying> implements CPacketFlying {
    public CPacketEventsFlying(WrappedPacketInFlying wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public boolean isGround() {
        return wrapper.isOnGround();
    }
}
