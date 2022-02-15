package Proxy;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerChannel extends ChannelInitializer<SocketChannel> {

    private final Channel channel;

    public ServerChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) {

        ChannelPipeline p = socketChannel.pipeline()

        .addLast(new StringDecoder())
        .addLast(new StringEncoder())
        .addLast(new SimpleChannelInboundHandler<String>() {
            @Override
            protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                channel.writeAndFlush(msg);
                    }
                });

    }

}