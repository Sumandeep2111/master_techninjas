package com.example.project_techninjas_android;

public class Note {

    private long id;
    private String title;
    private String content;
    private String date;
    private String time;

    Note(){}

    Note( String title, String content, String date, String time) {

        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    Note(long id, String title, String content, String date, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
