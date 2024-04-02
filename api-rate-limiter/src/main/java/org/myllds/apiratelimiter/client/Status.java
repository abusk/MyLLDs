package org.myllds.apiratelimiter.client;

public enum Status {
    OK(200), LIMITED(399);

    private final int code;
    Status(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
