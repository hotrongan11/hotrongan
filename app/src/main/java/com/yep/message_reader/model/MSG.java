package com.yep.message_reader.model;

import java.io.Serializable;

public class MSG implements Serializable {
    private  String number,time,body;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MSG(String number, String time, String body) {
        this.number = number;
        this.time = time;
        this.body = body;
    }
}
