package com.hackday.securekeyboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReqPaymentDto {
    private int userId;
    private int price;
    private String payPw;
}
