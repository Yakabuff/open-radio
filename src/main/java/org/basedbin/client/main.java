package org.basedbin.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class main {

    public static void main(String args[]) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;

        buf = new String("Hello").getBytes();

        DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 8001);
        ds.send(DpSend);
    }



}
