package com.acme.edu.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {

    public static void main(String[] args) {

        Logger logger = new Logger();

        try (Socket socket = new Socket("localhost", 6543);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             // BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()))
             ) {


            oos.writeObject(logger.log(5));
            //oos.writeObject(logger.log('A'));
            oos.writeObject(logger.log("Hello World!"));



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
