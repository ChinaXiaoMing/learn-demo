package com.example.demo.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) throws SocketException {
        DatagramSocket client = new DatagramSocket(12345);
        Runnable receive = new ReceiveThread(client);
        Thread receiveThread = new Thread(receive);
        receiveThread.start();
        System.out.println("======");
    }

}
