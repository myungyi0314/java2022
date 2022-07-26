package ioNetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class NettyHttpResponse extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;

            System.out.println("STATUS: " + response.status());
            System.out.println("VERSION: " + response.protocolVersion());
            System.out.println();

            if (!response.headers().isEmpty()) {
                for (CharSequence name : response.headers().names()) {
                    for (CharSequence value : response.headers().getAll(name)) {
                        System.out.println("HEADER: " + name + " = " + value);
                    }
                }
                System.out.println();
            }
            System.out.println("----------------- CONTENT START -----------------");
        }

        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;

            System.out.print(content.content().toString(CharsetUtil.UTF_8));
            System.out.flush();

            if (content instanceof LastHttpContent) {
                System.out.println();
                System.out.println("----------------- END OF CONTENT  -----------------");
                ctx.close();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}