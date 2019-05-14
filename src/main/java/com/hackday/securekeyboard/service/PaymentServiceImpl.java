package com.hackday.securekeyboard.service;

import com.hackday.securekeyboard.dao.UserDao;
import com.hackday.securekeyboard.dto.ReqApprovalToCompDto;
import com.hackday.securekeyboard.dto.ReqPaymentDto;
import com.hackday.securekeyboard.vo.CardCompanyInfo;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    private final UserDao userDao;

    public PaymentServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ReqApprovalToCompDto preApproval(CardCompanyInfo cardCompanyInfo, ReqPaymentDto reqPaymentDto) {
        ReqApprovalToCompDto reqApprovalToCompDto = new ReqApprovalToCompDto();

        boolean checkUser = userDao.isExistedUser(reqPaymentDto.getUserId());
        boolean checkPw = false;

        if(checkUser){
            checkPw = userDao.checkPassword(reqPaymentDto.getUserId(), reqPaymentDto.getPayPw());
        } else {
            System.out.println("해당하는 유저가 없습니다.");
//            @TODO Exception 처리
        }

        if(checkPw) {
            reqApprovalToCompDto.setPrice(reqPaymentDto.getPrice());
            reqApprovalToCompDto.setToken(userDao.getToken(reqPaymentDto.getUserId()));
        }

        return reqApprovalToCompDto;
    }
}
