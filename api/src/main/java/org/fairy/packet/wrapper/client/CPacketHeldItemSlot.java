package org.fairy.packet.wrapper.client;

public interface CPacketHeldItemSlot extends CPacket{
    int getSlot();

    @Override
    default String getFancyName() {
        return "ItemSlot";
    }
}
