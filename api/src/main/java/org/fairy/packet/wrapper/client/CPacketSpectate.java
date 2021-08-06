package org.fairy.packet.wrapper.client;

import java.util.UUID;

public interface CPacketSpectate extends CPacket {

    UUID getSpectated();

    @Override
    default String getFancyName() {
        return "Spectate";
    }
}
