package com.example.oriyitzhaki.selfchat;

public class Message {
    String time;
    String name;
    String content;

    public Message(String content, String name, String time) {
        this.time = time;
        this.name = name;
        this.content = content;
    }

    public Message(String time, String content) {
        this(time, "MyName", content);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
