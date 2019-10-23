package com.david.learn.powermockito;

public class SuppressMethod {

    public String format(String val) {
        String currency = getCurrency();
        return val.concat((currency != null ? currency : ""));
    }

    private String getCurrency() {
        return "$";
    }

}
