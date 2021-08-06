package org.fairy.packet.wrapper.client;


import org.fairy.packet.bytebuf.ByteBuf;

public interface CPacketCustomPayload extends CPacket {
    String getHeader();
    ByteBuf getData();

    @Override
    default String getFancyName() {
        return "CustomPayload";
    }
}
