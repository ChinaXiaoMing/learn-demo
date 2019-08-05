package com.example.demo.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) throws SocketException {
        DatagramSocket server = new DatagramSocket();
        Runnable send = new SendThread(server);
        Thread sendThread = new Thread(send);
        sendThread.start();
        System.out.println("=============");
    }

}
