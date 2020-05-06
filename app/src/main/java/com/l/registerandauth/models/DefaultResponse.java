package com.l.registerandauth.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private String message;

    public DefaultResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
