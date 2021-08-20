package com.polestarhc.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.polestarhc.thread.Study;

public class JsonExample {

    public static void main(String [] args) {

        // jsonExample 객체 생성.
        JsonExample jsonExample = new JsonExample();
        try {

            // "jsontest.json" 파일 생성
            jsonExample.writeFile("jsontest.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String path) throws JsonProcessingException {
        
        // objectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
       
        // study 객체 생성
        Study study = new Study();
        study.setPatiendId("13234");
        study.setPatientName("홍길동");
        study.setAccessionNo("123");
        study.setBirthday("149294");
        study.setAeTitle("OOOO");
        study.setModality("CT");

        // objectFile에 Study 입력됨
        String objectFile = objectMapper.writeValueAsString(study);

        // objectFile 출력
        System.out.println("JsonExample.writeFile OBJECT : " + objectFile);

        // xmlMapper 객체 생성
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xmlFile = xmlMapper.writeValueAsString(study.getPatientName());
        System.out.println("XmlExample.writeFile XML : " + xmlFile);
    }
}
