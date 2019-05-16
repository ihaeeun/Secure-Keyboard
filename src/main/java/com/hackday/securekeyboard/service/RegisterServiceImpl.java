package com.hackday.securekeyboard.service;

import com.hackday.securekeyboard.dao.UserDao;
import com.hackday.securekeyboard.dto.ReqRegisterCardDto;
import com.hackday.securekeyboard.dto.ReqRegisterToCompDto;
import com.hackday.securekeyboard.exception.NotFoundUser;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{
    private final UserDao userDao;

    public RegisterServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ReqRegisterToCompDto registerCard(ReqRegisterCardDto reqRegisterCardDto) {
        boolean checkUser = userDao.isExistedUser(reqRegisterCardDto.getUserId());

        if(checkUser) {
            return convert(reqRegisterCardDto);
        } else {
            throw new NotFoundUser();
        }
    }

    @Override
    public void updateToken(int userId, String token) {
        userDao.updateToken(userId, token);
    }

    private ReqRegisterToCompDto convert(ReqRegisterCardDto reqRegisterCardDto){
        ReqRegisterToCompDto reqRegisterToCompDto = new ReqRegisterToCompDto();

        reqRegisterToCompDto.setCardNum(reqRegisterCardDto.getCardNum());
        reqRegisterToCompDto.setExpiredDate(reqRegisterCardDto.getExpiredDate());
        reqRegisterToCompDto.setCvc(reqRegisterCardDto.getCvc());
        reqRegisterToCompDto.setCardPw(reqRegisterCardDto.getCardPw());
        reqRegisterToCompDto.setJuminNum(reqRegisterCardDto.getJuminNum());

        return reqRegisterToCompDto;
    }

}
