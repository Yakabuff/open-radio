package org.basedbin.server.threads;

import org.basedbin.server.RadioServer;
import org.basedbin.server.common.ServerCommand;

public class ThreadCommandHandler extends Thread{
    RadioServer radioServer;
    public ThreadCommandHandler(RadioServer radioServer){
        this.radioServer = radioServer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (radioServer.getCommands().size() > 0) {
                    ServerCommand sc = (ServerCommand) radioServer.getCommands().peek();

                    System.out.println("Handling "+ sc.getCommand());
                    radioServer.getConsoleCommandHandler().handleCommand((ServerCommand) radioServer.getCommands().take());
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
