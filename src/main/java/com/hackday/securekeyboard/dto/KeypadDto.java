package com.hackday.securekeyboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeypadDto {
    private String hash;
    private String base64;
}
