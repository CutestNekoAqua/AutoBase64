package me.waterdev.autobase64.Objects;

import java.util.UUID;

public class Result {

    private Form form;
    private int encryptionstrengh;
    private String input;
    private String output;
    private String uuid = UUID.randomUUID().toString();

    public Result(Form form, int encryptionstrengh, String input, String output) {
        this.form = form;
        this.encryptionstrengh = encryptionstrengh;
        this.input = input;
        this.output = output;
    }

    public String getUuid() {
        return uuid;
    }

    public Form getForm() {
        return form;
    }

    public int getEncryptionstrengh() {
        return encryptionstrengh;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void setEncryptionstrengh(int encryptionstrengh) {
        this.encryptionstrengh = encryptionstrengh;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
