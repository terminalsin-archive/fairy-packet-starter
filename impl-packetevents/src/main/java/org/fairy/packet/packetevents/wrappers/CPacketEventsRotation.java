package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketRotation;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;

public class CPacketEventsRotation extends PacketEventWrapper<WrappedPacketInFlying> implements CPacketRotation {
    public CPacketEventsRotation(WrappedPacketInFlying wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public float getYaw() {
        return wrapper.getYaw();
    }

    @Override
    public float getPitch() {
        return wrapper.getPitch();
    }

    @Override
    public boolean isGround() {
        return wrapper.isOnGround();
    }
}
