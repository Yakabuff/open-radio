package org.basedbin.server.common;

public class ServerCommand {
    String command;
    Loggable loggable;
    public ServerCommand(String c, Loggable l) {
        this.command = c;
        this.loggable =l;
    }

    public String getCommand(){
        return this.command;
    }
    public Loggable getLoggable() {
        return loggable;
    }

}
