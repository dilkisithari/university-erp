package com.uni.universityERP.dto;

public class LoginResponse {

    private boolean success;
    private String username;
    private String message;

    public static LoginResponse success(String username) {
        LoginResponse response = new LoginResponse();
        response.success = true;
        response.username = username;
        return response;
    }

    public static LoginResponse failure(String message) {
        LoginResponse response = new LoginResponse();
        response.success = false;
        response.message = message;
        return response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
