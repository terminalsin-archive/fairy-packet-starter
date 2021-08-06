package org.fairy.packet.bytebuf;

public interface ByteBuf {
    int getSize();

    int getReferenceCount();

    boolean isReadable();

    boolean isWriteable();

    int getReaderIndex();

    byte[] getData();

    void release();

    void clear();
}
