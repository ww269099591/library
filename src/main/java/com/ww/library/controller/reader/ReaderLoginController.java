package com.ww.library.controller.reader;

import com.ww.library.entity.Member;
import com.ww.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("Reader")
public class ReaderLoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("ReaderLogin")
    public ModelAndView ReaderLogin(String username, String password, HttpSession session){
        Member member=loginService.memberLogin(username);
        if (member == null||member.getPassword()!=password) {
            ModelAndView mv=new ModelAndView("login");
            mv.addObject("message","wrong");
            return mv;
        } else {
                ModelAndView mv=new ModelAndView("index");
                mv.addObject("message","success");
                session.setAttribute("_session_user",member);
                return mv;
        }
    }
}
