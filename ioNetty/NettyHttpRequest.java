package ioNetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.URISyntaxException;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class NettyHttpRequest {
    // SERVER URI
    private static final String RETRIEVE = "SERVER HOST IP:PORT"; // 수집
    private static final String PRODUCE = "SERVER HOST IP:PORT"; // 조회
    private static final String CONCURRENT = "SERVER HOST IP:PORT"; // 수집조회

    public static void main(String[] args) {

        EventLoopGroup group = new NioEventLoopGroup(); //  TCP 서버를 만드는 첫 번째 단계, java NIO 를 사용
        Bootstrap bootstrap = new Bootstrap(); // Bootstrap을 생성
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class); // EventLoopGroup과 NioSocketChannel 클래스를 연결
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception { // 연결할 서버의 주소와 포트번호를 InetSocketAddress로 구성
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new HttpClientCodec());
                pipeline.addLast(new NettyHttpResponse());
            }
        });

        String content = "{\"userId\": \"MONDAY\",\"amt\": \"10000\"}"; // 데이터

        try {
//            URI uri = new URI(RETRIEVE);
//            URI uri = new URI(PRODUCE);
            URI uri = new URI(CONCURRENT);
            FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, uri.getRawPath());
            request.headers().set(HttpHeaderNames.HOST, uri.getHost());
            request.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON);
            request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);

            ByteBuf byteBuf = Unpooled.copiedBuffer(content, StandardCharsets.UTF_8);
            request.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
            request.content().writeBytes(byteBuf);

            Channel ch = bootstrap.connect(uri.getHost(), uri.getPort()).sync().channel();
            ch.writeAndFlush(request);
            ch.closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}