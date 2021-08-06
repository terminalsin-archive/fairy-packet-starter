package org.fairy.packet.packetevents.injector;

import org.fairy.packet.data.PlayerData;
import org.fairy.packet.packetevents.netty.PacketEventsBuffer;
import org.fairy.packet.packetevents.netty.PacketEventsChannel;
import org.fairy.packet.LowLevelPacketListener;
import org.fairy.packet.PacketInjector;
import org.fairy.packet.netty.Channel;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class PacketEventsInjector implements PacketInjector {
    @Override
    public void inject(PlayerData data, Channel channel, LowLevelPacketListener packetListener) {
        final boolean instance = channel instanceof PacketEventsChannel;

        if (!instance) {
            throw new IllegalStateException("Channel is of invalid type! (Type not PacketEvents channel)");
        }

        final PacketEventsChannel packetEventsChannel = (PacketEventsChannel) channel;

        packetEventsChannel.getChannel().pipeline().addBefore("decoder", "fairy-bytebuf-handler",
                new ChannelInboundHandlerAdapter(){
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        if (msg instanceof ByteBuf) {
                            final org.fairy.packet.bytebuf.ByteBuf byteBuf = new PacketEventsBuffer((ByteBuf) msg);
                            final boolean cancel = packetListener.handle(data, byteBuf);

                            if (cancel)
                                return;
                        }

                        super.channelRead(ctx, msg);
                    }
                });
    }
}
