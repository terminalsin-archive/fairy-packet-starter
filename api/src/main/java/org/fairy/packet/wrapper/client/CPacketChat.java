package org.fairy.packet.wrapper.client;

public interface CPacketChat extends CPacket {
    String getMessage();

    @Override
    default String getFancyName() {
        return "Chat";
    }
}
