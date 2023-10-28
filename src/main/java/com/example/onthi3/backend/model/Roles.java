package com.example.onthi3.backend.model;

public enum Roles {
    ADMiNISTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXECUTIVE(3);
    private int code;

    Roles(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
