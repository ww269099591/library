package com.ww.library.controller.reader;

import com.ww.library.entity.Member;
import com.ww.library.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("Reader")
@Api(value="读者登陆接口")
public class ReaderLoginController {
    @Autowired
    LoginService loginService;
    @ApiOperation(value = "跳转到读者登陆页面", notes = "跳转到读者登陆页面")
    @RequestMapping(value="ToReaderLogin",method = RequestMethod.GET)
    public ModelAndView ToReaderLogin(){
        ModelAndView mv=new ModelAndView("ReaderLogin");
        return mv;
    }
    @ApiOperation(value = "根据用户名查询密码是否正确", notes = "根据用户名查询密码是否正确")
    @RequestMapping(value = "ReaderLogin",method = RequestMethod.POST)
    public ModelAndView ReaderLogin(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session){
        Member member=loginService.memberLogin(username);
        if (member == null||!member.getPassword().equals(password)) {
            ModelAndView mv=new ModelAndView("ReaderLogin");
            mv.addObject("message","wrong");
            return mv;
        }else{
                ModelAndView mv=new ModelAndView("index");
                mv.addObject("message","success");
                session.setAttribute("_session_user",member);
                return mv;
        }
    }
}
