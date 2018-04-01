package com.example.administrator.bestpritice;

/**
 * Created by Administrator on 2018/4/1 0001.
 */
public class Message {
    static public final int RECEIVE_MESSAGE = 0;//接收到的消息
    static public final int SEND_MESSAGE = 1;//发送的消息

    private String content;
    private int ms_type;

    public Message(int ms_type, String content) {
        this.ms_type = ms_type;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getMs_type() {
        return ms_type;
    }
}
