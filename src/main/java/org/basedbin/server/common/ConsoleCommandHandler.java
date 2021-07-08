package org.basedbin.server.common;

import org.basedbin.server.RadioServer;

public class ConsoleCommandHandler {
    private RadioServer radioServer;
    public ConsoleCommandHandler(RadioServer radioServer) {
        this.radioServer = radioServer;
    }

    public void handleCommand(ServerCommand serverCommand){
        String command = serverCommand.getCommand().toLowerCase();
        if(command.startsWith("echo")){
            serverCommand.getLoggable().log("test");

        }else{
            serverCommand.getLoggable().log(this.radioServer.getSender() + " "+command);
        }
    }
}
