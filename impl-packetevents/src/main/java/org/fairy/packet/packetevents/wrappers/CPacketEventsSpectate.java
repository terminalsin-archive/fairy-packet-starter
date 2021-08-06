package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketSpectate;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.spectate.WrappedPacketInSpectate;

import java.util.UUID;

public class CPacketEventsSpectate extends PacketEventWrapper<WrappedPacketInSpectate> implements CPacketSpectate {
    public CPacketEventsSpectate(WrappedPacketInSpectate wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public UUID getSpectated() {
        return wrapper.getUUID();
    }
}
