package org.fairy.packet.wrapper.client;

public interface CPacketFlying extends CPacket {
    boolean isGround();

    @Override
    default String getFancyName() {
        return "CPacketFlying";
    }
}
