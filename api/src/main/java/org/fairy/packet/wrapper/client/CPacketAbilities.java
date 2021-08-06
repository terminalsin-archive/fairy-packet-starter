package org.fairy.packet.wrapper.client;

import java.util.Optional;

public interface CPacketAbilities extends CPacket {
    boolean isFlying();

    Optional<Boolean> isVulnerable();

    Optional<Boolean> isAllowFlight();

    Optional<Boolean> isCreative();

    Optional<Float> getFlySpeed();

    Optional<Float> getWalkSpeed();

    @Override
    default String getFancyName() {
        return "Abilities";
    }
}
