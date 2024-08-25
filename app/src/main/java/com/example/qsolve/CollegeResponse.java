package com.example.qsolve;

import java.util.List;

public class CollegeResponse {

private boolean status;
private List<College> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<College> getData() {
        return data;
    }

    public void setData(List<College> data) {
        this.data = data;
    }
    public static class College{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
