package com.acme.edu.multithreading;

import java.io.IOException;

public class MultiClientServer {

    public static void main(String[] args) throws IOException {
        Thread connectionLoop = new Thread(new ServerAcceptor());

        connectionLoop.start();
    }

}
