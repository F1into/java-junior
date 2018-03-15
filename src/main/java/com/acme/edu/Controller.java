package com.acme.edu;

import com.acme.edu.formatter.PrefixFormatter;
import com.acme.edu.message.Message;

public class Controller {

    private static boolean calc = false;
    private static boolean first = true;

    private static int sumInt = 0;
    private static byte sumByte = 0;
    private static int counter = 1;
    private static String temporary = null;

    /**
     * Если вызов функции log() является первым, декорируем его
     * Если первый вызов типа String, включаем вычисления для iteration2
     */
    public void direct(Object message, boolean isString) {

        if (first) {
            new PrefixFormatter().format((Message) message);
            first = false;
            if (isString) {
                calc = true;
            }
        }

    }

    //region GETTER & SETTER
    public static boolean getCalc() {
        return calc;
    }
    public static void setFirst(boolean value) {
        first = value;
    }

    public int getSumInt() {
        return sumInt;
    }
    public void setSumInt(int sumInt) {
        this.sumInt = sumInt;
    }
    public void enlargeSumInt(int term) {
        sumInt += term;
    }

    public byte getSumByte() {
        return sumByte;
    }
    public void setSumByte(byte sumByte) {
        this.sumByte = sumByte;
    }
    public void enlargeSumByte(byte term) { sumByte += term; }

    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getTemporary() {
        return temporary;
    }
    public void setTemporary(String temporary) {
        this.temporary = temporary;
    }
    //endregion

}
