package com.example.qsolve;

public class Buy_Computer_courses {
    private String number;
    private String name;
    private boolean isDownloaded;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public Buy_Computer_courses(String number, String name, boolean isDownloaded) {
        this.number = number;
        this.name = name;
        this.isDownloaded = isDownloaded;
    }
}
