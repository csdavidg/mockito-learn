package com.david.learn.powermockito;

public class FinalMethod {

    public String getAccessToFinalMethod() {
        return "Accessed" + getPrivateFinalValue();
    }

    private final String getPrivateFinalValue() {
        return "private_final_value";
    }

    public final String getPublicFinalValue() {
        return "public_final_value";
    }

}
