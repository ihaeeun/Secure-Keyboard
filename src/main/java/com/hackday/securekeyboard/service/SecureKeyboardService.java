package com.hackday.securekeyboard.service;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;

import com.hackday.securekeyboard.dto.KeypadDto;

public interface SecureKeyboardService {
    public ArrayList<KeypadDto> generateKeypadImages();
}
