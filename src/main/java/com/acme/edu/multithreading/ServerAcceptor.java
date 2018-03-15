package com.acme.edu.multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAcceptor implements Runnable {

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(9999);) {

            while (!Thread.interrupted()) {
                Socket clientSocket = serverSocket.accept();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
