package com.david.learn.powermockito;

public class SuppressConstructor {

    int value = 100;

    public SuppressConstructor(int val) {
        val = val / 0;
    }
}
