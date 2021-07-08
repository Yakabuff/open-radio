package org.basedbin.server;

import org.basedbin.server.common.ConsoleCommandHandler;
import org.basedbin.server.common.Loggable;
import org.basedbin.server.common.ServerCommand;
import org.basedbin.server.threads.ThreadCommandHandler;
import org.basedbin.server.threads.ThreadCommandReader;
import org.basedbin.server.threads.ThreadServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import java.net.SocketException;

public class RadioServer implements Runnable, Loggable {
    public final static Logger logger = Logger.getLogger(RadioServer.class.getName());
    private String version = "0.0.1";
    private ArrayBlockingQueue commands = new ArrayBlockingQueue(50);

    private boolean isRunning = true;


    private ThreadCommandHandler threadCommandHandler;
    private ConsoleCommandHandler consoleCommandHandler;

    public RadioServer(String port) {

    }

    public static void main(String args[]) throws SocketException {
        RadioServer radioServer = new RadioServer("8001");

        new ThreadServer("Server", radioServer).start();
    }

    public boolean startServer() {
        logger.info("Starting openRadio version " + version);
        ThreadCommandReader threadCommandReader = new ThreadCommandReader("commandReaderThread", this);
        threadCommandReader.setDaemon(true);
        threadCommandReader.start();

        threadCommandHandler = new ThreadCommandHandler(this);
        threadCommandHandler.setDaemon(true);
        threadCommandHandler.start();

        consoleCommandHandler = new ConsoleCommandHandler(this);


        return true;
    }

    public boolean isRunning(){
        return isRunning;
    }

    @Override
    public void run() {
        this.startServer();
        while(true){

        }
    }

    @Override
    public void log(String s) {
        logger.info(s);
    }

    @Override
    public String getSender() {
        return "[SERVER]";
    }

    public ArrayBlockingQueue getCommands() {
        return commands;
    }

    public ConsoleCommandHandler getConsoleCommandHandler() {
        return consoleCommandHandler;
    }
}