package com.ww.library;

import com.ww.library.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {
    @Autowired
    private  RedisTemplate redisTemplate;
    @Autowired
    LoginService loginService;

    @Test
    public void TestRedis(){
        System.out.println(loginService.saveMember("269099591@qq.com"));

    }

    @Test
    public void TestMq(){
        loginService.putRegistMsgInMq("269099591");
    }



}
