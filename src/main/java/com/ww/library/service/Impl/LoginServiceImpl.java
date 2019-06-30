package com.ww.library.service.Impl;

import com.ww.library.dao.MemberMapper;
import com.ww.library.entity.Member;
import com.ww.library.service.LoginService;
import io.swagger.models.auth.In;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MemberMapper memberDao;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.mail.username}")
    private String from;

    public static final long DEFAULT_EXPIRE = 1;

    @Override
    public Member memberLogin(String username) {
        Member member = memberDao.selectMemberByUsername(username);
        return member;
    }

    @Override
    public String sendEmail(String email) {
        Integer v=(int)(Math.random()*1000000);
        String verificationCode=v.toString();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 邮件发送者
        message.setTo(from); // 邮件接受者
        message.setSubject("验证码"); // 主题
        message.setText(verificationCode); // 内容
        mailSender.send(message);
        return verificationCode;
    }

    @Override
    public void setIntoRedis(String email, String verificationCode) {
        redisTemplate.opsForValue().set(email,verificationCode,60, TimeUnit.SECONDS);
    }

    @Override
    public boolean checkVerificationCode(String email, String verificationCode) {
        String redisVerificationCode=(String)redisTemplate.opsForValue().get(email);
        if(redisVerificationCode.equals(verificationCode)){
            return true;
        }
        return false;
    }

    @Override
    public Integer saveMember(String email) {

        if(isRegist(email)){
            return -1;
        }
        Member member =new Member();
        member.setUsername(email);
        member.setStatus("2");//status设置为2时，跳转到补充信息页面
        Integer m=memberDao.insert(member);
        System.out.println(m);
        return m;
    }

    /**
     * 判断该用户名是否已注册
     * 返回true为已注册
     * 返回false为未注册
     * @param username
     * @return
     */
    @Override
    public Boolean isRegist(String username) {
        if(memberDao.selectMemberByUsername(username)!=null){
            return true;
        }else
            return false;
    }

    @Override
    public void putRegistMsgInMq(String email) {
        rabbitTemplate.convertAndSend("SuccessMq",email);
    }


}
