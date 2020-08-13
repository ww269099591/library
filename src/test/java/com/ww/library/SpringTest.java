package com.ww.library;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SpringTest {
    private AtomicInteger atomicInteger=new AtomicInteger();

    @Test
    public void beanTest() {
        ClassPathResource resource = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        atomicInteger.incrementAndGet();
        try {
            Class c1=Class.forName("com.ww.library.entity.Book");
        } catch (Exception e) {
        }
    }

    @Test
    public void IntegerTest(){
        Map<String,Object> map=new HashMap<>();
        if((Integer)map.get("code")!=0)    {
            System.out.println(13);
        }
    }

    @Test
    public void ConcurrentHashMapTest(){
        new HashMap<>();

    }

    public static void main(String[] args){
        Map<String,Object> map=new HashMap<>();
        map.put("a","123");
        System.out.println(map.get("a").toString());
    }
}
