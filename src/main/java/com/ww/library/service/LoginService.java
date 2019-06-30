package com.ww.library.service;

import com.ww.library.entity.Member;

public interface LoginService {
    Member memberLogin(String username);

    String sendEmail(String email);

    void setIntoRedis(String email,String verificationCode);

    boolean checkVerificationCode(String email,String verificationCode);

    Integer saveMember(String email);

    Boolean isRegist(String username);

    void putRegistMsgInMq(String email);
}
