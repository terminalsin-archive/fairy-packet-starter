package org.fairy.packet;


import org.bukkit.plugin.java.JavaPlugin;
import org.fairy.packet.data.PlayerData;

import java.util.HashSet;
import java.util.UUID;

public abstract class PacketProvider {
    protected final PacketManager manager;
    protected final PacketListener highListener;
    protected final LowLevelPacketListener lowListener;
    protected final PacketInjector injector;
    protected final InjectQueue injectQueue;

    public PacketProvider(PacketManager manager, PacketListener highListener, LowLevelPacketListener lowListener, PacketInjector injector) {
        this.manager = manager;
        this.highListener = highListener;
        this.lowListener = lowListener;
        this.injector = injector;
        this.injectQueue = new InjectQueue();
    }

    public abstract void load();

    public abstract void init();

    public abstract void quit();

    public abstract void inject(final PlayerData data);

    protected static class InjectQueue extends HashSet<UUID> {
        @Override
        public boolean isEmpty() {
            return super.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return super.contains(o);
        }

        @Override
        public boolean add(UUID uuid) {
            return super.add(uuid);
        }

        @Override
        public boolean remove(Object o) {
            return super.remove(o);
        }
    }
}
