package com.example.project_techninjas_android;

public class Note {

    private Long id;
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

    Note(Long id, String title, String content, String date, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
