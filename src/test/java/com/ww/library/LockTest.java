package com.ww.library;

public class LockTest {

    private Boolean flag = true;

    public  synchronized void doSomeThing() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "       " + "doSomeThing");
        Thread.sleep(1000);
        doOtherThing();
    }

    public synchronized void doOtherThing() {
        Boolean flag = true;
        while (flag) {
            try {
                System.out.println(Thread.currentThread().getName() + "       " + "doOtherThing");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) {
        LockTest lockTest = new LockTest();
        Thread newThread = new Thread(() -> {
            lockTest.doOtherThing();
        }, "线程a");

        newThread.start();
        LockTest lockTest2 = new LockTest();
        Thread newThread2 = new Thread(() -> {
            try {
                lockTest2.doSomeThing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程b");
        newThread2.start();

//        ArrayList
    }


}
