package org.fairy.packet.wrapper.client;

public interface CPacketTabComplete extends CPacket {

    String getText();

    @Override
    default String getFancyName() {
        return "TabComplete";
    }
}
