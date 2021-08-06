package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketPositionRotation;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;

public class CPacketEventsPositionRotation extends PacketEventWrapper<WrappedPacketInFlying> implements CPacketPositionRotation {
    public CPacketEventsPositionRotation(WrappedPacketInFlying wrapper, Channel channel) {
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
