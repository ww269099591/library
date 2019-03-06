package com.ww.library.controller.reader;

import com.ww.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReaderLoginController {
    @Autowired
    LoginService loginService;

    public ModelAndView ReaderLogin(String ){
        ModelAndView mv=new ModelAndView();

        return mv;
    }




}
