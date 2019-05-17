package com.hackday.securekeyboard.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class KeyMappingSet {
    private ArrayList<String> hashedAndEncrypted;
    private ArrayList<String> encrytedOnly;
}
