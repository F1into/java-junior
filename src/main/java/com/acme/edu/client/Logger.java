package com.acme.edu.client;

import java.io.Serializable;

public class Logger implements Serializable {

    Object log(int message) {
        return (Object)message;
    }

    Object log(char message) {
        return message;
    }

    String log(String message) {
        return message;
    }

}
