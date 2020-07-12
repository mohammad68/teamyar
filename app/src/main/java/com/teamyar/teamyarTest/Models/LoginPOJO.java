package com.teamyar.teamyarTest.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPOJO {

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("delete_old_session")
    @Expose
    private boolean deleteOldSession;

    public LoginPOJO(int type, String message, boolean deleteOldSession) {
        this.type = type;
        this.message = message;
        this.deleteOldSession = deleteOldSession;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDeleteOldSession() {
        return deleteOldSession;
    }

    public void setDeleteOldSession(boolean deleteOldSession) {
        this.deleteOldSession = deleteOldSession;
    }
}



