package com.acme.edu.server;

import com.acme.edu.Logger;

public class Skeleton {
    public static void unpack(Object msg) {

        if (msg instanceof Integer) {
            Logger.log((int)msg);
        }

        if (msg instanceof Byte) {
            Logger.log((byte)msg);
        }

        if (msg instanceof Character) {
            Logger.log((char)msg);
        }

        if (msg instanceof Boolean) {
            Logger.log((boolean)msg);
        }

        if (msg instanceof String) {
            Logger.log((String)msg);
        }

    }
}
