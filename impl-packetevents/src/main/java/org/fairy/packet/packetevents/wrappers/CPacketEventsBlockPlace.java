package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketBlockPlace;
import org.fairy.packet.packetevents.PacketEventWrapper;
import org.fairy.packet.wrapper.spigot.packet.packetevents.translate.PacketEventsTranslators;
import org.fairy.packet.wrapper.wrapper.mcp.ArtemisDirection;
import org.fairy.packet.wrapper.wrapper.mcp.ArtemisHand;
import org.fairy.packet.wrapper.wrapper.vector.Vector3F;
import org.fairy.packet.wrapper.wrapper.vector.Vector3I;
import io.github.retrooper.packetevents.packetwrappers.play.in.blockplace.WrappedPacketInBlockPlace;
import io.github.retrooper.packetevents.utils.player.Direction;
import io.github.retrooper.packetevents.utils.player.Hand;
import io.github.retrooper.packetevents.utils.vector.Vector3f;
import io.github.retrooper.packetevents.utils.vector.Vector3i;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public final class CPacketEventsBlockPlace extends PacketEventWrapper<WrappedPacketInBlockPlace> implements CPacketBlockPlace {
    public CPacketEventsBlockPlace(WrappedPacketInBlockPlace wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public ArtemisHand getHand() {
        final Hand bridge = wrapper.getHand();
        return PacketEventsTranslators.HAND.transform(bridge);
    }

    @Override
    public ArtemisDirection getDirection() {
        final Direction bridge = wrapper.getDirection();
        return PacketEventsTranslators.DIRECTION.transform(bridge);
    }

    @Override
    public Vector3I getClickedBlock() {
        final Vector3i bridge = wrapper.getBlockPosition();
        return PacketEventsTranslators.VECTOR_3I.transform(bridge);
    }

    @Override
    public Optional<Vector3F> getClickedOffset() {
        final Optional<Vector3f> optionalBridge = wrapper.getCursorPosition();
        if (!optionalBridge.isPresent())
            return Optional.empty();

        final Vector3f bridge = optionalBridge.get();
        final Vector3F translated = PacketEventsTranslators.VECTOR_3F.transform(bridge);

        return Optional.of(translated);
    }

    @Override
    public Optional<ItemStack> getItemStack() {
        return wrapper.getItemStack();
    }
}
