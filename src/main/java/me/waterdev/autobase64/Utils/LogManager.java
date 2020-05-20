package me.waterdev.autobase64.Utils;

import me.waterdev.autobase64.Main;
import me.waterdev.autobase64.Objects.Result;

public class LogManager {

    public String getlog() {
        String finished = "";

        for (Result r : Main.list) {
            finished = finished + r.getForm().toString() + " | Encryption Strengh: " + r.getEncryptionstrengh() + " | Input: " + r.getInput() + " | Output: " + r.getOutput() + "\r\n";
        }

        return finished;
    }

}
