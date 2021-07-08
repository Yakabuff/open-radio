package org.basedbin.server.threads;

import org.basedbin.server.RadioServer;

public class ProcessThread extends Thread{
    RadioServer radioServer;
    public ProcessThread(String name, RadioServer radioServer) {
        super(name);
        this.radioServer = radioServer;
    }

    @Override
    public void run() {
        System.out.println("Started login thread. Will be listening to new connections");
//        while(true){
//            //receive datagram
//
//            byte[] buf = new byte[256];
//            DatagramPacket packet = new DatagramPacket(buf, buf.length);
//            try {
//                server.socket.receive(packet);
//                System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()).trim());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void authenticate(String username, String pw){

    }

    private void generateSession(String username){

    }

}
