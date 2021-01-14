package com.kromemedia.mediaapi.contollers;

public class SimpleMessage {
    public String msg;
    public String err;

    public SimpleMessage() {
    }

    public SimpleMessage(String msg, String err) {
        this.msg = msg;
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
