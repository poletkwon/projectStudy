package com.polestarhc.thread;

import java.util.List;

public class Thread1 implements Runnable{

        List<Study> studyList;

        public Thread1(List<Study> studyList){
            // 기본생성자
            this.studyList = studyList;
        }

    @Override
    public void run() {
            for(int i = 0 ; i < studyList.size() ; i++){
                Study study = studyList.get(i);
                study.setPatientName("강아지");
                study.setPatiendId(study.getPatiendId()+"A");
                System.out.println("A : " + study.toString());

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
