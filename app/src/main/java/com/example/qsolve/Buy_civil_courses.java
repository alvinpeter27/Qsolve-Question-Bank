package com.example.qsolve;

public class Buy_civil_courses {

    private String number;
    private String name;
    private boolean isDownloaded;


    public Buy_civil_courses(String number, String name, boolean isDownloaded) {
        this.number = number;
        this.name = name;
        this.isDownloaded = isDownloaded;

    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }


}
