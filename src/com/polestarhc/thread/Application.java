package com.polestarhc.thread;

import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

public class Application {
    public static void main(String[] args) {

        List<Study> list = new ArrayList<>();

        for(int i=0 ; i< 10 ; i++){
            Study study = new Study();

            study.setPatiendId("PID"+i);
            study.setPatientName("Name"+i);
            list.add(study);
        }


        Thread thread1 = new Thread(new Thread1(list));
        Thread thread2 = new Thread(new Thread2(list));

        thread1.start();
        thread2.start();

        try {
            System.out.println("sleep start");
            Thread.sleep(10*1000);
            System.out.println("sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Study study : list){
            System.out.println(study.toString());
        }
    }
}
