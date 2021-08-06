package org.fairy.packet.bytebuf;

import java.util.Arrays;

public class ByteArrayByteBuf implements ByteBuf {
    private byte[] data;

    public ByteArrayByteBuf(byte[] data) {
        this.data = data;
    }

    @Override
    public int getReferenceCount() {
        return 1;
    }

    @Override
    public boolean isReadable() {
        return true;
    }

    @Override
    public boolean isWriteable() {
        return true;
    }

    @Override
    public int getReaderIndex() {
        return 0;
    }

    @Override
    public void release() {
        data = null;
    }

    @Override
    public void clear() {
        Arrays.fill(data, (byte) 0);
    }

    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public byte[] getData() {
        return data;
    }
}
