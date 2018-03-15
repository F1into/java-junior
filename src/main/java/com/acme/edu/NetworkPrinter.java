package com.acme.edu;

public class NetworkPrinter implements Printer {


    @Override
    public void out(Object lineToPrint) {
        String toOut = lineToPrint.toString();
    }

    @Override
    public void outPrefix(String prefix) {
        String toOut = prefix;
    }
}
