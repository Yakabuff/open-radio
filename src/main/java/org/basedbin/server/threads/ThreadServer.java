package org.basedbin.server.threads;

import org.basedbin.server.RadioServer;

public class ThreadServer extends Thread{

    RadioServer radioServer;

    public ThreadServer(String name, RadioServer s){
        super(name);
        this.radioServer = s;
    }

    @Override
    public void run() {
        radioServer.run();
    }
}
