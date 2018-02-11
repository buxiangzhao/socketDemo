package com.sunno.server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        int port = 55555;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server---开启-----");
        // 建立链接
        Socket socket = serverSocket.accept();
        // 获取请求,建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len=inputStream.read(bytes))!=-1){
            System.out.println(len);
            System.out.println(new String(bytes, 0, len,"UTF-8"));
            stringBuilder.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from client: " + stringBuilder);
        // 输出响应
        String msg = "server--响应数据---"+stringBuilder;
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes("utf-8"));

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
