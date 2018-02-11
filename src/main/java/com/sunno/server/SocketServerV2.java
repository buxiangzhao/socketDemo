package com.sunno.server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketServerV2 {

    public static void main(String[] args) throws IOException {
        int port = 55555;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server---开启-----");
        // 建立链接
        Socket socket = serverSocket.accept();
        // 获取请求,建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        while (true){
            int first = inputStream.read();
            System.out.println(Integer.toBinaryString(first));
            if (first==-1){
                break;
            }
            int second= inputStream.read();
            System.out.println(Integer.toBinaryString(second));
            int length = (first<<8)+second;
            bytes = new byte[length];
            inputStream.read(bytes);
            System.out.println("first--"+ Integer.toBinaryString(first));
            System.out.println("second--"+ Integer.toBinaryString(second));
            System.out.println("length--"+length);
            System.out.println("get message from client: " + new String(bytes,"utf-8"));
        }
        // 输出响应
        String msg = "server--响应数据---";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes("utf-8"));
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
