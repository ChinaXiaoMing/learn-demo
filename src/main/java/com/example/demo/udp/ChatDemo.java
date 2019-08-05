package com.example.demo.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatDemo {

}

//发送消息线程
class SendThread implements Runnable {

    private DatagramSocket datagramSocket;

    public SendThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                if (str.equals("886")) {
                    break;
                }
                byte[] bytes = str.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                        InetAddress.getByName("localhost"), 12345);
                datagramSocket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        datagramSocket.close();
    }
}

//接收消息线程
class ReceiveThread implements Runnable {

    private DatagramSocket datagramSocket;

    public ReceiveThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(packet);
                String ip = packet.getAddress().getHostAddress();
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println(ip + "---接收到发送过来的数据是：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        datagramSocket.close();
    }
}

