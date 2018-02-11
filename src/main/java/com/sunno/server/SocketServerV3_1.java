package com.sunno.server;


import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class SocketServerV3_1 {

    public static void main(String[] args) throws IOException {
        int port = 55555;
        // server 一直等待链接的到来
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server开启-----");
        // 开启多线程，需要使用线程池，防止高并发时创建过多线程耗尽资源
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        //
        int count = 1 ;
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("client:"+count+"---连接---");
            new Runnable(){
                public void run() {
//                    try {
                        // 获取请求,建立缓冲区进行读取
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
//                        String line;
//                        StringBuilder stringBuilder = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            stringBuilder.append(line);
//                        }
//                        System.out.println("get message from client: " + stringBuilder);

//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            };
            count += 1;
            socket.close();
        }
    }


}
