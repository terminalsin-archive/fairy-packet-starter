package org.fairy.packet.data;

import java.util.UUID;

public interface PlayerData {
    String getName();

    UUID getUuid();

    <T> T getPlayer();
}
