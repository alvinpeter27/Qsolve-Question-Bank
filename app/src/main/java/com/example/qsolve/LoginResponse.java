package com.example.qsolve;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("access_token")
    private String token;

    @SerializedName("status")
    private String status;

    public String getStatus() {

        return status;
    }

    String getToken(){

        return token;
    }
}
