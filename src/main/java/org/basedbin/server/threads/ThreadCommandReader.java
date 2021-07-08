package org.basedbin.server.threads;

import org.basedbin.server.RadioServer;
import org.basedbin.server.common.ServerCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class ThreadCommandReader extends Thread{
    RadioServer radioServer;

    public ThreadCommandReader(String name, RadioServer s){
        super(name);
        this.radioServer = s;
    }

    @Override
    public void run() {
//        BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        try {
            while(true) {
                String command = scanner.nextLine();
                if (command != null) {
                    try {
                        System.out.println("sending " + command);
                        this.radioServer.getCommands().put(new ServerCommand(command, this.radioServer));
                        command = null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
                    Thread.sleep(10L);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
