package com.dreamky.netty.client;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHander extends ChannelInboundHandlerAdapter {
	
	//TODO 为啥定义一个final
	//private  ByteBuf firstMessage;
	
	private int count=0;
	
	

	public TimeClientHander() {
		/*byte[] req = "getTime".getBytes();
		firstMessage = Unpooled.buffer(req.length);
		firstMessage.writeBytes(req);*/
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		 ByteBuf message = null;
		 //这种情况下，模拟了TCP 传输过程中粘包（拆包的问题）
		 //客户端共发送了100次请求，服务端仅仅收到了1次含100个getTime 的请求
		 //相应客户端也仅仅1次
		for (int i = 1; i <= 100; i++) {
			byte[] req = "getTime".getBytes();
			message = Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
			System.out.println(Thread.currentThread().getName() + "客户端发送第"  + i + "次请求");
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req,"UTF-8");
		System.out.println("现在的时间是：" + body);
		System.out.println(Thread.currentThread().getName()  + "客户端收到服务端的第：" + ++count + "次响应");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
	

}
