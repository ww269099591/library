package com.ww.library.service.Impl;

import com.ww.library.dao.MemberMapper;
import com.ww.library.entity.Member;
import com.ww.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MemberMapper memberDao;

    @Override
    public Member memberLogin(String username) {
        Member member = memberDao.selectMemberByUsername(username);
        return member;
    }
}
