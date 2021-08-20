package com.polestarhc.fileIO;


import com.polestarhc.thread.Study;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonTest {

    public static void main (String [] args){

        // JSON SIMPLE lib 사용.
        // JSONObject 객체 생성.
        JSONObject obj = new JSONObject();
        Study study = new Study();

//        obj.put("ID", "12345");
//        obj.put("나이", "100살");
//        obj.put("이름", "태우");
//        obj.put(study.toString(),"");


        for(int i =0; i<10000; i++){
            study.setPatiendId("ID" + i);
            study.setPatientName("권태우" + i);

            obj.put(i,study.toString());

        //    System.out.println(obj);
        }


//            study.setPatientId("123");
//            study.setPatientName("권태우");

//        obj.put(1,study);

//        for (int i = 0; i < obj.size(); i++){
//
//        }
//        obj.put( 0 ,study.getPatientId());
//        obj.put( 1 ,study.getPatientName());



//        study.setPatientName("태우");
//        study.setPatientId("100살");

        // JSON SIMPLE lib 내의 JSONArray 사용.
        // JSONArray 리스트 객체 생성.

//        JSONArray list = new JSONArray();
//        list.add("내용1");
//        list.add("내용2");
//        list.add("내용3");
//
//        obj.put("메세지", list);

        try {
            FileWriter fw = new FileWriter("C:/workspace/jsontest.json");
            fw.write(obj.toJSONString());
//            fw.write(obj.toJSONString());

            // flush() 는 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
            // Stream에 남아있는 데이터를 강제로 내보내는 역할을 한다.
            // 호스가 연결된 수도 꼭지를 틀고 나서 잠그면 호스안에 물이 조금 남아있게 된다.
            // 그 남아있는 물을 빼내기 위해 호스를 들어올리는 경우가 있다.
            // flush() 는 호스에 고인 물을 빼내는 역할을 하는것이다.

            fw.flush();

            // FileWriter는 스트림을 이용하여 파일의 내용을 읽어들인다
            // 이때 close()를 이용하여 스트림을 닫으면 그 스트림을 통하여 파일에 쓰는것은 불가능해진다.
            // 파일을 스트림으로 읽어들이는 것은 메모리를 소모하므로 작업이 끝나면 close()를 통하여 스트림을 닫아 메모리를 확보한다.
            fw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(obj);


    }
}
