package com.acme.edu.multithreading;

import java.io.*;
import java.net.Socket;

public class ClientSession implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private ServerService service;

    public ClientSession(Socket accept, ServerService service) throws IOException {
        this.clientSocket = accept;
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    @Override
    public void run() {

            try {

                while (!Thread.interrupted()) {
                    String clientInpuLine = this.reader.readLine();
                    service.doCommand(clientInpuLine);
                    this.writer.println();
                }

                reader.close();
                writer.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
