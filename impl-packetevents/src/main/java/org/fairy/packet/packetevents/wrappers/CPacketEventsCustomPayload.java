package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.bytebuf.ByteArrayByteBuf;
import org.fairy.packet.bytebuf.ByteBuf;
import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketCustomPayload;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.custompayload.WrappedPacketInCustomPayload;

public class CPacketEventsCustomPayload extends PacketEventWrapper<WrappedPacketInCustomPayload> implements CPacketCustomPayload {
    public CPacketEventsCustomPayload(WrappedPacketInCustomPayload wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public String getHeader() {
        return wrapper.getTag();
    }

    @Override
    public ByteBuf getData() {
        final byte[] data = wrapper.getData();

        return new ByteArrayByteBuf(data);
    }
}
