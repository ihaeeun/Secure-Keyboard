package com.hackday.securekeyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqRegisterToCompDto {
    private String cardNum;
    private String expiredDate;
    private String cvc;
    private String cardPw;
    private String juminNum;
}