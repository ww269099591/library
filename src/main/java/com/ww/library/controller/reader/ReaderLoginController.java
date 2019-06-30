package com.ww.library.controller.reader;

import com.ww.library.entity.Member;
import com.ww.library.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("Reader")
@Api(value="读者登陆接口")
public class ReaderLoginController {
    @Autowired
    LoginService loginService;

    private Logger logger = Logger.getLogger(String.valueOf(getClass()));



    @ApiOperation(value = "跳转到读者登陆页面", notes = "跳转到读者登陆页面")
    @RequestMapping(value="ToReaderLogin")
    public String  ToReaderLogin(){
        //ModelAndView mv=new ModelAndView("ReaderLogin");
        return "ReaderLogin";
    }
    @RequestMapping(value="ToRegist",method = RequestMethod.GET)
    public ModelAndView ToRegist(){
        ModelAndView mv=new ModelAndView("regist");
        return mv;
    }

    @RequestMapping(value = "jump")
    public String jump(String page){
        if(page.equals("ToReaderLogin")){
            return "ReaderLogin";
        }
        if(page.equals("ToRegist")){
            return "regist";
        }
        return null;
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

    @RequestMapping(value="regist",method = RequestMethod.POST)
    public ModelAndView regist(Member member){
       ModelAndView mv=new ModelAndView();
           return mv;
    }
    @RequestMapping(value="getVerificationCode")
    @ResponseBody
    public Map<String,Object> getVerificationCode(String email){
        Map<String,Object> map=new HashMap<>();
        if (email!=null) {
            if(loginService.isRegist(email)){
                map.put("result","fail");
                logger.info("该邮箱已注册");
                return map;
            }
            String verificationCode = loginService.sendEmail(email);
            if(verificationCode !=null){
                loginService.setIntoRedis(email,verificationCode);
            }
        }else{
            map.put("result","fail");
            map.put("code",400);
            logger.info("email为空或者格式不正确");
            return map;
        }
        map.put("result","success");
        return map;
    }

    @RequestMapping(value="checkVerificationCode")
    @ResponseBody
    public Map<String,Object> checkVerificationCode(String email,String verificationCode){
        Map<String,Object> map =new HashMap<>();
        if(email==null||verificationCode==null){
            map.put("result","fail");
            return map;
        }
        if(loginService.checkVerificationCode(email,verificationCode)){
            if(loginService.saveMember(email)>-1) {
                //使用rabbitmq把注册成功消息发送给邮箱
                loginService.putRegistMsgInMq(email);
                map.put("result", "success");
            }
        }else{
            map.put("result","fail");
        }
        return  map;
    }




}
