package com.hackday.securekeyboard.service;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hackday.securekeyboard.dto.KeypadDto;

@RunWith(SpringRunner.class)
public class SecureKeyboardServiceImplTest {

    @Test
    public void test() {
        SecureKeyboardServiceImpl secureKeyboardService = new SecureKeyboardServiceImpl();
        ArrayList<KeypadDto> keypadDtos = null;
        for (int i = 0; i < 10; i++) {
            System.out.println(keypadDtos.get(i).getHashAndEncryptedValue());
        }
    }
}
