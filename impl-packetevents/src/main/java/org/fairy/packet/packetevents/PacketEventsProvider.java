package org.fairy.packet.packetevents;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.event.annotation.PacketHandler;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.plugin.java.JavaPlugin;
import org.fairy.packet.*;
import org.fairy.packet.data.PlayerData;
import org.fairy.packet.packetevents.injector.PacketEventsInjector;
import org.fairy.packet.packetevents.translate.PacketEventsTranslators;
import org.fairy.packet.wrapper.Packet;

import java.util.UUID;

public class PacketEventsProvider extends PacketProvider {
    public PacketEventsProvider(PacketManager manager, PacketListener highListener, LowLevelPacketListener lowListener, PacketInjector injector) {
        super(manager, highListener, lowListener, injector);
    }

    @Override
    public void load() {
        PacketEvents.create(manager.plugin());
        PacketEvents.get().getSettings()
                .compatInjector(false)
                .checkForUpdates(false)
                .bStats(false)
                .fallbackServerVersion(ServerVersion.v_1_8_8);

        PacketEvents.get().loadAsyncNewThread();
    }

    @Override
    public void init() {
        PacketEvents.get().init();
        PacketEvents.get().getEventManager().registerListener(new io.github.retrooper.packetevents.event.PacketListener() {
            @PacketHandler
            private void handle(PacketPlayReceiveEvent packetPlayReceiveEvent) {
                final PlayerData data = manager.getData(packetPlayReceiveEvent.getPlayer().getUniqueId());

                if (data == null) {
                    return;
                }

                final Packet packet = PacketEventsTranslators.PACKET.transform(packetPlayReceiveEvent);

                if (packet == null)
                    return;

                final UUID uuid = packetPlayReceiveEvent.getPlayer().getUniqueId();

                if (!injectQueue.isEmpty() && injectQueue.contains(uuid)) {
                    injector.inject(data, packet.getChannel(), lowListener);
                    injectQueue.remove(uuid);
                }

                final boolean cancel = highListener.onPacket(data, packet);
                packetPlayReceiveEvent.setCancelled(cancel);
            }
        });
    }

    @Override
    public void quit() {
        PacketEvents.get().stop();
    }

    @Override
    public void inject(PlayerData data) {
        injectQueue.add(data.getUuid());
    }
}
