package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketSetCreativeSlot;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.setcreativeslot.WrappedPacketInSetCreativeSlot;
import org.bukkit.inventory.ItemStack;

public class CPacketEventsSetCreativeSlot extends PacketEventWrapper<WrappedPacketInSetCreativeSlot> implements CPacketSetCreativeSlot {
    public CPacketEventsSetCreativeSlot(WrappedPacketInSetCreativeSlot wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public int getSlot() {
        return wrapper.getSlot();
    }

    @Override
    public ItemStack getItemStack() {
        return wrapper.getClickedItem();
    }
}
