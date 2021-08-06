package org.fairy.packet.packetevents.netty;

import org.fairy.packet.netty.Channel;

public class PacketEventsChannel implements Channel {
    private final io.netty.channel.Channel channel;

    public PacketEventsChannel(io.netty.channel.Channel channel) {
        this.channel = channel;
    }

    @Override
    public void close() {
        if (!channel.isOpen() || channel.pipeline() == null)
            return;

        channel.close();
    }

    public io.netty.channel.Channel getChannel() {
        return channel;
    }
}
