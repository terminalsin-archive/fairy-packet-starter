package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketChat;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.chat.WrappedPacketInChat;

public class CPacketEventsChat extends PacketEventWrapper<WrappedPacketInChat> implements CPacketChat {
    public CPacketEventsChat(WrappedPacketInChat wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public String getMessage() {
        return wrapper.getMessage();
    }
}
