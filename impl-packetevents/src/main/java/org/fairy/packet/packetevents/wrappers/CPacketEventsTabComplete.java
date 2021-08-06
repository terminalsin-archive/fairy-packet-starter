package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketTabComplete;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.tabcomplete.WrappedPacketInTabComplete;

public class CPacketEventsTabComplete extends PacketEventWrapper<WrappedPacketInTabComplete> implements CPacketTabComplete {
    public CPacketEventsTabComplete(WrappedPacketInTabComplete wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public String getText() {
        return wrapper.getText();
    }
}
