package Proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProxyChannel extends ChannelInitializer<SocketChannel> {

    private final Proxy proxy;

    private final List<Integer> nodeServers = new ArrayList<>();

    public ProxyChannel(Proxy proxy) throws FileNotFoundException {
        this.proxy = proxy;
        readPorts();
    }

    int serverNumber = 0;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        if(serverNumber == nodeServers.size()){
           serverNumber = 0;
        }

        int chosenServer = nodeServers.get(serverNumber);

        Bootstrap bootstrap = new Bootstrap();
        Channel channel = bootstrap.group(proxy.getWorkerGroup())
                .channel(NioSocketChannel.class)
                .handler(new ServerChannel(socketChannel))
                .connect("localhost", chosenServer).sync().channel();

        ChannelPipeline p = socketChannel.pipeline();

        p.addLast(new StringDecoder());
        p.addLast(new StringEncoder());
        p.addLast(new SimpleChannelInboundHandler<String>() {
            /*
            ProxyChannelHandler as Callback
            */
            @Override
            protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                channel.writeAndFlush(msg);
                serverNumber++;
                System.out.println("Port nr: " + chosenServer + " | Server number: " + serverNumber + "/" + nodeServers.size());
            }
        });
    }
    public void readPorts() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ports.txt"));
        while(scanner.hasNextInt()) {
            nodeServers.add(scanner.nextInt());
        }
        scanner.close();
    }

}
