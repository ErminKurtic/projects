package com.example.demo.shared;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Util {
    public String generateHash(String uniqueProperty) {
        try {
            MessageDigest hashFunction = MessageDigest.getInstance("SHA3-256");
            byte[] digest = hashFunction.digest(uniqueProperty.getBytes());
            return digest.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
