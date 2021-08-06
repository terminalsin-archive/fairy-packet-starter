package org.fairy.packet.wrapper.client;

public interface CPacketPosition extends CPacketFlying {

    double getX();

    double getY();

    double getZ();

    @Override
    default String getFancyName() {
        return "Position";
    }
}
