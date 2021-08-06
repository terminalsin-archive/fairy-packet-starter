package org.fairy.packet.packetevents.wrappers;

import org.fairy.packet.netty.Channel;
import org.fairy.packet.wrapper.client.CPacketHeldItemSlot;
import org.fairy.packet.packetevents.PacketEventWrapper;
import io.github.retrooper.packetevents.packetwrappers.play.in.helditemslot.WrappedPacketInHeldItemSlot;

public class CPacketEventsHeldItemSlot extends PacketEventWrapper<WrappedPacketInHeldItemSlot> implements CPacketHeldItemSlot {
    public CPacketEventsHeldItemSlot(WrappedPacketInHeldItemSlot wrapper, Channel channel) {
        super(wrapper, channel);
    }

    @Override
    public int getSlot() {
        return wrapper.getCurrentSelectedSlot();
    }
}
