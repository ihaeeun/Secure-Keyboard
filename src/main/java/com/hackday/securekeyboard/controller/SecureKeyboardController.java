package com.hackday.securekeyboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackday.securekeyboard.dto.KeypadDto;
import com.hackday.securekeyboard.service.SecureKeyboardService;

@Controller
@RequestMapping(value = "/securekeyboard")
public class SecureKeyboardController {
    private final SecureKeyboardService secureKeyboardService;

    public SecureKeyboardController(SecureKeyboardService secureKeyboardService) {
        this.secureKeyboardService = secureKeyboardService;
    }

    @GetMapping("/{card-company}")
    public String getSecureKeyboard(@PathVariable("card-company") String cardCompany,
                Model model){

        ArrayList<KeypadDto> keypadDtos = secureKeyboardService.generateKeypadImages();
        model.addAttribute("keyMapId", UUID.randomUUID().toString().replaceAll("-", ""));
        model.addAttribute("keypadDtoList", keypadDtos);
        return "secure-keyboard";
    }
}
