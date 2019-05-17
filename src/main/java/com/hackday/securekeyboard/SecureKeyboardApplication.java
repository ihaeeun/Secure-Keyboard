package com.hackday.securekeyboard;

import java.util.Hashtable;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackday.securekeyboard.vo.KeyMappingSet;

@SpringBootApplication
public class SecureKeyboardApplication {
    public static Hashtable<String, KeyMappingSet> globalKeyMappingTable;

    public static void main(String[] args) {
        globalKeyMappingTable = new Hashtable<>();
        SpringApplication.run(SecureKeyboardApplication.class, args);
    }
}