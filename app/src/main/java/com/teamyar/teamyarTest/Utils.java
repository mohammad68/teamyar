package com.teamyar.teamyarTest;

public class Utils {
    public static boolean isEmailValid(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.trim().matches(emailPattern);
    }
}
