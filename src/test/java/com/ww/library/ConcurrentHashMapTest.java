package com.ww.library;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    @Test
    public void test(){
        ConcurrentHashMap<Integer,Integer> concurrentHashMap=new ConcurrentHashMap(16);
        for(int i=0;i<100;i++){
            concurrentHashMap.put(i,i);
        }

    }
}
