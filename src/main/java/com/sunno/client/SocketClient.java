package com.sunno.client;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketClient {
    public static  String testMsg = "啊发生发射点发射点发射点发射点法顶顶顶顶顶顶顶顶顶顶顶顶顶" +
            "适当放松法啊啊啊啊啊啊啊啊啊啊啊啊啊啊顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦" +
            "阿三发射点发射点发呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃" +
            "钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇哇日日日日日日日日日日日日日日日日日日日";
    public static void main(String[] args) throws IOException {
        // 带链接服务器的IP地址和端口
        String host = "127.0.0.1";
        int port = 55555;
        // 与服务器建立链接
        Socket socket = new Socket(host,port);
        // 请求参数
        String msg = "你好,今天就要放假了";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes("utf-8"));
        // 通知服务器 数据发送完毕
        socket.shutdownOutput();

        // 接收服务端响应
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder builder = new StringBuilder();
        while ((len=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len,"utf-8"));
            builder.append(new String(bytes,0,len,"utf-8"));
        }
        System.out.println("client---接收响应--");
        System.out.println(builder);
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
