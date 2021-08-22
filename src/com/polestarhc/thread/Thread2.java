package com.polestarhc.thread;

import java.util.List;

public class Thread2 implements Runnable{

    List<Study> studyList;

    public Thread2(List<Study> studyList){
        // 기본생성자
        this.studyList = studyList;
    }

    @Override
    public void run() {
        for(int i = studyList.size()-1 ; i >= 0 ; i--){
            Study study = studyList.get(i);
    //        study.setPatientName();
            study.setPatiendId(study.getPatiendId()+"B");
            System.out.println("B : " + study.toString());

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
