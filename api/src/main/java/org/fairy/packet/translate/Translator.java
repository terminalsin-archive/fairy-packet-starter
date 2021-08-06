package org.fairy.packet.translate;

public interface Translator<F, T> {
    T transform(final F from);
}
