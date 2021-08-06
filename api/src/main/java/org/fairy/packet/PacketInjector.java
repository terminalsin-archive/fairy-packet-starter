package org.fairy.packet;

import org.fairy.packet.data.PlayerData;
import org.fairy.packet.netty.Channel;

public interface PacketInjector {
    void inject(final PlayerData data, final Channel channel, final LowLevelPacketListener packetListener);
}
