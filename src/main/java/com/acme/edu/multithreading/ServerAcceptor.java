package com.acme.edu.multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ServerAcceptor implements Runnable {

    private ServerService service = new ConcreteServerService();
    private Set<Thread> clientSessions = new HashSet<>();

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(9999);) {
            serverSocket.setSoTimeout(1_000);

            while (!Thread.interrupted()) {
                Socket clientSocket = serverSocket.accept();
                if (clientSocket != null) {
                    Thread thread = new Thread(
                            new ClientSession(clientSocket,
                            service)
                    );
                    clientSessions.add(thread);
                    thread.start();
                }
            }

            clientSessions.forEach(Thread::interrupt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
