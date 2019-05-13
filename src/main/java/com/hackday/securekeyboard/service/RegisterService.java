package com.hackday.securekeyboard.service;

import com.hackday.securekeyboard.dto.ReqRegisterCardDto;
import com.hackday.securekeyboard.dto.ReqRegisterToCompDto;
import com.hackday.securekeyboard.dto.ResRegisterResultDto;

public interface RegisterService {
    ReqRegisterToCompDto registerCard(ReqRegisterCardDto reqRegisterCardDto);
    void updateToken (int userId, String token);
}