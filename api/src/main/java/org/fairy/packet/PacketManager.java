package org.fairy.packet;

import org.bukkit.plugin.java.JavaPlugin;
import org.fairy.packet.data.PlayerData;

import java.util.UUID;

public interface PacketManager {
    JavaPlugin plugin();

    PlayerData getData(final UUID uuid);
}
