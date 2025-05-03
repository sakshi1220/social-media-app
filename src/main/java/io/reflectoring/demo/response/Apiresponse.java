package io.reflectoring.demo.response;

public class Apiresponse {
    private String message;
    private boolean status;
    public String getMessage() {
        return message;
    }
    public Apiresponse() {
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Apiresponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
