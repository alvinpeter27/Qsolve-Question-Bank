package com.example.qsolve;

public class Buy_course_item {
    private String number;
    private String name;
    private boolean isDownloaded;

    public Buy_course_item(String number, String name, boolean isDownloaded) {
        this.number = number;
        this.name = name;
        this.isDownloaded = isDownloaded;
    }

    public String getName() {

        return name;
    }

    public String getNumber() {

        return number;
    }

    public boolean isDownloaded() {

        return isDownloaded;
        }
}
