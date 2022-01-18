package com.codegym.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

public class RandomPassword {
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; //a-z
    private static final String digits = "0123456789"; //0-9
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final Random generator = new Random();
    private static String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    public static String getRandomPassword(){
        int numberOfCharactor = 10;
        String randomPassword = randomAlphaNumeric(numberOfCharactor);
        return randomPassword;
    }
    public static String setPassword(String password){
        String newPassword = "";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        newPassword = bCryptPasswordEncoder.encode(password);
        return newPassword;
    }
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
}
