package com.hackday.securekeyboard.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Encryption {
    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Value(value = "${publicKeyA}")
    private String publicKey;


    public List<String> rsaEncryption() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
        List<String> rsaNumbers = new ArrayList<String>();
        Key decodedKey = KeyFactory.getInstance("RSA").generatePublic(
                new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));

        Cipher cipher = Cipher.getInstance("RSA");

//        @TODO : Exception
        try{
            for (String number : NUMBERS) {
                cipher.init(Cipher.ENCRYPT_MODE, decodedKey);
                byte[] cipherArr = cipher.doFinal(number.getBytes());
                String cipherNum = Base64.getEncoder().encodeToString(cipherArr);
                rsaNumbers.add(cipherNum);
            }
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return rsaNumbers;
    }

    public List<String> rsaToSha1(List<String> rsaNumbers) {
        List<String> sha1Number = sha1(rsaNumbers);
        return sha1Number;
    }

    public List<String> compareHash(String userInput, List<String> rsaNumbers){
        List<String> inputs = Arrays.asList(userInput);
        List<String> result = new ArrayList<>();
        for(String input : inputs){
            for(String rsaNumber : rsaNumbers){
                if(input.equals(rsaNumber)){
                    result.add(rsaNumber);
                }
            }
        }

        return result;
    }

    private List<String> arrayToSha1(){
        List<String> numberList = Arrays.asList(NUMBERS);

        return sha1(numberList);
    }


    private List<String> sha1(List<String> object){
        List<String> hashArray = new ArrayList<>();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            for(String hashNumber : object){
                digest.update(hashNumber.getBytes("utf8"));
                hashArray.add(String.format("%040x", new BigInteger(1, digest.digest())));
            }
        } catch (Exception e){
//            @TODO : Exception
            e.printStackTrace();
        }

        return hashArray;
    }

}
