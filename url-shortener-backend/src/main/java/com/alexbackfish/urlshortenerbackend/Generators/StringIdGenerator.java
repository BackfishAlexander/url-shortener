package com.alexbackfish.urlshortenerbackend.Generators;

import java.security.SecureRandom;

public class StringIdGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";


    public static String getID() {
        StringBuilder result = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(ALLOWED_CHARACTERS.length());
            result.append(ALLOWED_CHARACTERS.charAt(index));
        }
        return result.toString();
    }
}