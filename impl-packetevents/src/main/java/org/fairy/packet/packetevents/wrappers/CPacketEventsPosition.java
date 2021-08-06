package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.packetevents.PacketEventWrapper;
import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketPosition;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;

public class CPacketEventsPosition extends PacketEventWrapper<WrappedPacketInFlying> implements CPacketPosition {
    public CPacketEventsPosition(WrappedPacketInFlying wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public double getX() {
        return wrapper.getPosition().getX();
    }

    @Override
    public double getY() {
        return wrapper.getPosition().getY();
    }

    @Override
    public double getZ() {
        return wrapper.getPosition().getZ();
    }

    @Override
    public boolean isGround() {
        return wrapper.isOnGround();
    }
}
