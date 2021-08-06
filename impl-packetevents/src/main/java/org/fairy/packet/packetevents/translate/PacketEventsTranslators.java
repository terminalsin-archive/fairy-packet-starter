package org.fairy.packet.packetevents.translate;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.in.abilities.WrappedPacketInAbilities;
import io.github.retrooper.packetevents.packetwrappers.play.in.blockplace.WrappedPacketInBlockPlace;
import io.github.retrooper.packetevents.packetwrappers.play.in.chat.WrappedPacketInChat;
import io.github.retrooper.packetevents.packetwrappers.play.in.custompayload.WrappedPacketInCustomPayload;
import io.github.retrooper.packetevents.packetwrappers.play.in.entityaction.WrappedPacketInEntityAction;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;
import io.github.retrooper.packetevents.packetwrappers.play.in.helditemslot.WrappedPacketInHeldItemSlot;
import io.github.retrooper.packetevents.packetwrappers.play.in.setcreativeslot.WrappedPacketInSetCreativeSlot;
import io.github.retrooper.packetevents.packetwrappers.play.in.spectate.WrappedPacketInSpectate;
import io.github.retrooper.packetevents.packetwrappers.play.in.tabcomplete.WrappedPacketInTabComplete;
import io.github.retrooper.packetevents.packetwrappers.play.in.windowclick.WrappedPacketInWindowClick;
import io.github.retrooper.packetevents.utils.player.Direction;
import io.github.retrooper.packetevents.utils.player.Hand;
import io.github.retrooper.packetevents.utils.vector.Vector3f;
import io.github.retrooper.packetevents.utils.vector.Vector3i;
import io.netty.channel.Channel;
import lombok.val;
import org.fairy.packet.packetevents.netty.PacketEventsChannel;
import org.fairy.packet.packetevents.wrappers.*;
import org.fairy.packet.wrapper.Packet;
import org.fairy.packet.mcp.PlayerAction;
import org.fairy.packet.translate.Translator;
import org.fairy.packet.vector.Vector3F;
import org.fairy.packet.vector.Vector3I;

public class PacketEventsTranslators {
    public static final Translator<Channel, PacketEventsChannel> CHANNEL = new Translator<Channel, PacketEventsChannel>() {
        @Override
        public PacketEventsChannel transform(Channel from) {
            return new PacketEventsChannel(from);
        }
    };

    public static final Translator<PacketPlayReceiveEvent, Packet> PACKET = new Translator<PacketPlayReceiveEvent, Packet>() {
        @Override
        public Packet transform(PacketPlayReceiveEvent from) {
            val player = from.getPlayer();
            val channel = (Channel) PacketEvents.get().getPlayerUtils().getChannel(player);
            val nmsPacket = from.getNMSPacket();
            val packetId = from.getPacketId();

            final PacketEventsChannel changedChannel = CHANNEL.transform(channel);

            switch (packetId) {
                case PacketType.Play.Client.CUSTOM_PAYLOAD:
                    val customPayload = new WrappedPacketInCustomPayload(nmsPacket);
                    return new CPacketEventsCustomPayload(customPayload, changedChannel);

                case PacketType.Play.Client.BLOCK_PLACE:
                    val blockPlace = new WrappedPacketInBlockPlace(nmsPacket);
                    return new CPacketEventsBlockPlace(blockPlace, changedChannel);

                case PacketType.Play.Client.WINDOW_CLICK:
                    val windowCLick = new WrappedPacketInWindowClick(nmsPacket);
                    return new CPacketEventsWindowClick(windowCLick, changedChannel);

                case PacketType.Play.Client.SET_CREATIVE_SLOT:
                    val creativeSlot = new WrappedPacketInSetCreativeSlot(nmsPacket);
                    return new CPacketEventsSetCreativeSlot(creativeSlot, changedChannel);

                case PacketType.Play.Client.ENTITY_ACTION:
                    val entityAction = new WrappedPacketInEntityAction(nmsPacket);
                    return new CPacketEventsEntityAction(entityAction, changedChannel);

                case PacketType.Play.Client.ABILITIES:
                    val abilities = new WrappedPacketInAbilities(nmsPacket);
                    return new CPacketEventsAbilities(abilities, changedChannel);

                case PacketType.Play.Client.HELD_ITEM_SLOT:
                    val heldItemSlot = new WrappedPacketInHeldItemSlot(nmsPacket);
                    return new CPacketEventsHeldItemSlot(heldItemSlot, changedChannel);

                case PacketType.Play.Client.CHAT:
                    val chat = new WrappedPacketInChat(nmsPacket);
                    return new CPacketEventsChat(chat, changedChannel);
                case PacketType.Play.Client.TAB_COMPLETE:
                    val tabComplete = new WrappedPacketInTabComplete(nmsPacket);
                    return new CPacketEventsTabComplete(tabComplete, changedChannel);

                case PacketType.Play.Client.SPECTATE:
                    val spectate = new WrappedPacketInSpectate(nmsPacket);
                    return new CPacketEventsSpectate(spectate, changedChannel);

                default:
                    break;
            }

            if (PacketType.Play.Client.Util.isInstanceOfFlying(packetId)) {
                val flying = new WrappedPacketInFlying(nmsPacket);

                if (flying.isMoving() && flying.isRotating()) {
                    return new CPacketEventsPositionRotation(flying, changedChannel);
                } else if (flying.isMoving()) {
                    return new CPacketEventsPosition(flying, changedChannel);
                } else if (flying.isRotating()) {
                    return new CPacketEventsRotation(flying, changedChannel);
                } else {
                    return new CPacketEventsFlying(flying, changedChannel);
                }
            }

            return null;
        }
    };
    
    public static final Translator<Hand, org.fairy.packet.mcp.Hand> HAND = new Translator<Hand, org.fairy.packet.mcp.Hand>() {
        @Override
        public org.fairy.packet.mcp.Hand transform(Hand from) {
            return org.fairy.packet.mcp.Hand.values()[from.ordinal()];
        }
    };

    public static final Translator<Direction, org.fairy.packet.mcp.Direction> DIRECTION = new Translator<Direction, org.fairy.packet.mcp.Direction>() {
        @Override
        public org.fairy.packet.mcp.Direction transform(Direction from) {
            return org.fairy.packet.mcp.Direction.getDirection(from.getFaceValue());
        }
    };

    public static final Translator<WrappedPacketInEntityAction.PlayerAction, PlayerAction> PLAYER_ACTION = new Translator<WrappedPacketInEntityAction.PlayerAction, PlayerAction>() {
        @Override
        public PlayerAction transform(WrappedPacketInEntityAction.PlayerAction from) {
            return PlayerAction.values()[from.ordinal()];
        }
    };

    public static final Translator<Vector3f, Vector3F> VECTOR_3F = new Translator<Vector3f, Vector3F>() {
        @Override
        public Vector3F transform(Vector3f from) {
            return new Vector3F(from.getX(), from.getY(), from.getZ());
        }
    };

    public static final Translator<Vector3i, Vector3I> VECTOR_3I = new Translator<Vector3i, Vector3I>() {
        @Override
        public Vector3I transform(Vector3i from) {
            return new Vector3I(from.getX(), from.getY(), from.getZ());
        }
    };
}
