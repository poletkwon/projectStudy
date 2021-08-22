package com.polestarhc.thread;

public class ThreadTest implements Runnable {

    private int id;
    public ThreadTest(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for(int i=0; i < 10; i++) {
            System.out.println("ThreadTest["+id+"]["+i+"].run " + System.currentTimeMillis());
        }

    }
}
