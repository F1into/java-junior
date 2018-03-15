package com.acme.edu.server;

import com.acme.edu.Buffer;
import com.acme.edu.Logger;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Acceptor {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(6543)) {

            while (true) {

                try (Socket session = server.accept();
                     ObjectInputStream ois = new ObjectInputStream(session.getInputStream());
                     PrintWriter pw = new PrintWriter(new OutputStreamWriter(session.getOutputStream()));
                ) {

                    while (true) {
                        Object msg = ois.readObject();
                        Skeleton.unpack(msg);
                        Buffer.flush();
                        // pw.println(message + " world!");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }





        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
