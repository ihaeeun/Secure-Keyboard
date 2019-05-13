package com.hackday.securekeyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqRegisterCardDto {
    private int userId;
    private String cardNum;
    private String expiredDate;
    private String cvc;
    private String cardPw;
    private String juminNum;
}
