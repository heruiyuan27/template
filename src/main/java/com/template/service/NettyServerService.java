package com.template.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class NettyServerService {

    public static final int TCP_PORT = 9201;

    @PostConstruct
    public void init() {
        try {
            startNettyServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startNettyServer() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1); // 接受连接线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup(); // 处理连接线程组

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();

                            // 添加字符串编解码器，指定字符集为UTF-8
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));

                            // 添加业务处理器
                            pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                    // 打印接收到的消息
                                    System.out.println("收到客户端 [" + ctx.channel().remoteAddress() + "] 的消息: " + msg);

                                    // 构造回复消息
                                    String response = "服务器已收到您的消息: " + msg;

                                    // 发送回复
                                    ctx.writeAndFlush(response);
                                    System.out.println("已回复客户端: " + response);
                                }

                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    System.out.println("客户端连接建立: " + ctx.channel().remoteAddress());
                                    super.channelActive(ctx);
                                }

                                @Override
                                public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                    System.out.println("客户端连接断开: " + ctx.channel().remoteAddress());
                                    super.channelInactive(ctx);
                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                    System.out.println("处理客户端 [" + ctx.channel().remoteAddress() + "] 时发生异常: " + cause.getMessage());
                                    ctx.close();
                                }
                            });
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128) // 连接队列大小
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // 保持长连接

            // 绑定端口并启动服务
            ChannelFuture f = b.bind(TCP_PORT).sync();
            System.out.println("服务器启动成功，监听端口: " + TCP_PORT);

            // 等待服务器通道关闭
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            System.out.println("服务器已关闭");
        }


    }


}
