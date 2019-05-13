package com.hackday.securekeyboard.dao;

import com.hackday.securekeyboard.dto.ResRegisterResultDto;
import com.hackday.securekeyboard.vo.User;

public interface UserDao {
    User getUser(int user_id);
    boolean isExistedUser(int userId);
    int setToken(int userId, String token);
}
