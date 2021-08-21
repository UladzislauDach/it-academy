package model;

import java.time.LocalDateTime;

public class Message {
    private String from;
    private LocalDateTime sendAt;
    private String text;

    public Message(String from, LocalDateTime sendAt, String text) {
        this.from = from;
        this.sendAt = sendAt;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    public void setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
