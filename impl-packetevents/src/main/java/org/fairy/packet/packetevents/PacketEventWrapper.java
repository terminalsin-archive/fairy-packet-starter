package org.fairy.packet.packetevents;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.Packet;

public abstract class PacketEventWrapper<T> implements Packet {
    protected T wrapper;
    protected Channel channel;

    public PacketEventWrapper(T wrapper, Channel channel) {
        this.wrapper = wrapper;
        this.channel = channel;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

}
