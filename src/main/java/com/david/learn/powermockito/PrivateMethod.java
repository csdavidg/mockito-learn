package com.david.learn.powermockito;

public class PrivateMethod {

    public String exposeSecretValue() {
        return getSecretValue();
    }

    private String getSecretValue() {
        return "SecretKey&&%)";
    }

}
