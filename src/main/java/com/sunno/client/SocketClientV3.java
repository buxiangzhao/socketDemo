package com.sunno.client;


import java.io.*;
import java.net.Socket;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketClientV3 {
    public static void main(String[] args) throws IOException {
        // 带链接服务器的IP地址和端口
        String host = "127.0.0.1";
        int port = 55555;
        // 与服务器建立链接
        Socket socket = new Socket(host,port);
        // 请求参数
        String msg = "你好,今天就要放假了1";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes("utf-8"));
        // 通知服务器 数据发送完毕
        socket.shutdownOutput();

        // 接收服务端响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line=reader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println("client---接收响应--"+stringBuilder);
        outputStream.close();
        socket.close();
    }
}
