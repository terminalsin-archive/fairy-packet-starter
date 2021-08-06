package org.fairy.packet;

import org.fairy.packet.data.PlayerData;
import org.fairy.packet.wrapper.Packet;

public interface PacketListener {
    boolean onPacket(final PlayerData data, final Packet packet);
}
