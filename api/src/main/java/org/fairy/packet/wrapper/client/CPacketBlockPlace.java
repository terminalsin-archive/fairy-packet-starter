package org.fairy.packet.wrapper.client;

import org.fairy.packet.wrapper.wrapper.mcp.ArtemisDirection;
import org.fairy.packet.wrapper.wrapper.mcp.ArtemisHand;
import org.fairy.packet.wrapper.wrapper.vector.Vector3F;
import org.fairy.packet.wrapper.wrapper.vector.Vector3I;

import java.util.Optional;

public interface CPacketBlockPlace extends CPacket {

    ArtemisHand getHand();

    ArtemisDirection getDirection();

    Vector3I getClickedBlock();

    /**
     *
     * @return
     */
    Optional<Vector3F> getClickedOffset();

    /**
     * Returns the ItemStack type used for placing a block. This can vary depending the
     * scenario (such as direction 255) as to where the following won't be provided.
     *
     * @param <T> Type parameter representing the ItemStack type defined by the wrapper
     * @return ItemStack used for the block place. This can be empty for hand clicks.
     */
    <T> Optional<T> getItemStack();

    @Override
    default String getFancyName() {
        return "BlockPlace";
    }
}
