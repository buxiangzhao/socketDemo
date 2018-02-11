package com.sunno.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketServerV3 {

    public static void main(String[] args) throws IOException {
        int port = 55555;
        ServerSocket serverSocket = new ServerSocket(port);
        int count = 1 ;
        while (true){
            System.out.println("server:"+count+"---开启");
            Socket socket = serverSocket.accept();
            // 获取请求,建立缓冲区进行读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println("get message from client: " + stringBuilder);
            count++;
            socket.close();
        }



        // 建立链接



        // 输出响应
//        String msg = "server--响应数据---"+stringBuilder;
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write(msg.getBytes("utf-8"));
//        outputStream.close();
//        socket.close();
//        serverSocket.close();
    }


}
