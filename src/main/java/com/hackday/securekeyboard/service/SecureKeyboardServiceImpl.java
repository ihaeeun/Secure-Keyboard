package com.hackday.securekeyboard.service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.hackday.securekeyboard.dto.KeypadDto;
//import com.hackday.securekeyboard.util.Encryption;

@Service
public class SecureKeyboardServiceImpl implements SecureKeyboardService {

    private String getBase64FromFile(String classPathResource) {
        byte[] fileContent = null;
        try {
            File keyImage = new ClassPathResource(classPathResource).getFile();
            fileContent = FileUtils.readFileToByteArray(keyImage);
        } catch (IOException e) {
            // TODO : runtime exception 상속 받아서 던질 것.
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }

    @Override
    public ArrayList<KeypadDto> generateKeypadImages() {
        ArrayList<KeypadDto> keypadDtoList = new ArrayList<KeypadDto>(10);
//        Encryption encryptionUtil = new Encryption();
        List<String> hashedKeyList = null;
//        try {
//            hashedKeyList = encryptionUtil.rsaToSha1(encryptionUtil.rsaEncryption());
//        } catch (Exception e) {
//            // TODO : runtime exception 상속받아서 던질 것!
//            e.printStackTrace();
//        }
        hashedKeyList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            hashedKeyList.add("hashvalue" + i);
        }

        // 이미지 불러와서 base64 적용하고,
        ArrayList<String> b64ImageStrings = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            b64ImageStrings.add(getBase64FromFile("img/" + i + ".png"));
            keypadDtoList.add(new KeypadDto(hashedKeyList.get(i), b64ImageStrings.get(i)));
        }

        keypadDtoList.add(new KeypadDto("blank", getBase64FromFile("img/blank.png")));
        keypadDtoList.add(new KeypadDto("blank", getBase64FromFile("img/blank.png")));

        // 여기서 순서를 섞어 준 다음에
        Collections.shuffle(keypadDtoList);
        return keypadDtoList;
    }

}
