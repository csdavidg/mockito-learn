package com.david.learn.powermockito;

public class StaticInitializationBlock {

    public static int value;

    static {
        value = 100 / 0;
        System.out.println("In static block");
    }

}
