package com.sunno.client;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketClientV2 {
    public static void main(String[] args) throws IOException {
        // 带链接服务器的IP地址和端口
        String host = "127.0.0.1";
        int port = 55555;
        // 与服务器建立链接
        Socket socket = new Socket(host,port);
        // 请求参数
        OutputStream outputStream = socket.getOutputStream();
        String msg = "hello,bxz";
        // 计算消息长度
        byte[] sendBytes = msg.getBytes("utf-8");
        // 优先推送消息长度
        int test = 102400000;
        System.out.println(Integer.toBinaryString(test>>8));
        System.out.println(Integer.toBinaryString(test));
        outputStream.write(test>>8);
//        outputStream.write(sendBytes.length>>8);
//        outputStream.write(sendBytes.length);
        outputStream.write(test);
        System.out.println(sendBytes.length);
        // 发送消息
        outputStream.write(sendBytes);
        outputStream.flush();
        //=================此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        msg = "第二条消息";
        sendBytes = msg.getBytes("UTF-8");
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);
        outputStream.flush();
        //=================此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        msg = "the third message!";
        sendBytes = msg.getBytes("UTF-8");
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);
        outputStream.flush();

//        // 通知服务器 数据发送完毕
//        socket.shutdownOutput();
//
//        // 接收服务端响应
//        InputStream inputStream = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        StringBuilder builder = new StringBuilder();
//        while ((len=inputStream.read(bytes))!=-1){
//            builder.append(new String(bytes,0,len,"utf-8"));
//        }
//        System.out.println("client---接收响应--");
//        System.out.println(builder);
//        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
