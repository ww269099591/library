package com.ww.library.VmTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryTest {
    Runtime runtime=Runtime.getRuntime();

    @Test
    public void testHeap(){


        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(runtime.freeMemory()+"    "+runtime.totalMemory());
        }

    }

    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        System.out.println(runtime.freeMemory()+"    "+runtime.totalMemory()+"     ");
        stackLeak();
    }

    @Test
    public void testStack(){
        MemoryTest oom = new MemoryTest();
        try {
            oom.stackLeak();

            } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

    class OOMObject {
        int i=0;
    }

    @Test
    public void testConstantPool(){
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
            System.out.println(runtime.freeMemory()+"    "+runtime.totalMemory()+"     ");
        }
    }


}
