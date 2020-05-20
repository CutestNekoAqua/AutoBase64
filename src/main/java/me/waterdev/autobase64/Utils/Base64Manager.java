package me.waterdev.autobase64.Utils;

import me.waterdev.autobase64.Main;
import me.waterdev.autobase64.Objects.Form;
import me.waterdev.autobase64.Objects.Result;

import java.util.Base64;

public class Base64Manager {

    private String start;
    private int strengh = 0;

    public Base64Manager(String startstring) {
        start = startstring;
    }

    public String encode(int times) {
        int i = 0;
        byte[] b = start.getBytes();

        while(i < times) {
            b = Base64.getEncoder().encode(b);
            strengh++;
            i++;
        }

        Main.list.add(new Result(Form.ENCODED, strengh, start, new String(b)));

        return new String(b);
    }

    public String decode() {
        boolean keepon = true;
        byte[] b = start.getBytes();

        while(keepon) {
            try {
                b = Base64.getDecoder().decode(b);
                strengh++;
            } catch (IllegalArgumentException e){
                keepon = false;
            }
        }

        Main.list.add(new Result(Form.DECODED, strengh, start, new String(b)));

        return new String(b);
    }

}
