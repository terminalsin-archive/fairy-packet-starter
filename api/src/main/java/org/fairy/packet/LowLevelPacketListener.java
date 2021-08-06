package org.fairy.packet;

import org.fairy.packet.data.PlayerData;
import org.fairy.packet.bytebuf.ByteBuf;

public interface LowLevelPacketListener {
    boolean handle(final PlayerData data, final ByteBuf byteBuf);
}
