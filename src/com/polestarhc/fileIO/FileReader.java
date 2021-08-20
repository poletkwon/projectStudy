package com.polestarhc.fileIO;

import java.io.*;

public class FileReader {

    private void readFile() {
        File file = new File("read_target.txt");
        boolean status = file.exists();
        System.out.println("FileReader.readFile : " + status +", " + file.getAbsolutePath());

        // 1. 파일안의 내용을 읽으시오
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytesIn = new byte[128];
            int read = 0;
            long size = 0;
            String value = null;
            while ((read = fileInputStream.read(bytesIn)) != -1) {
                byteArrayOutputStream.write(bytesIn, 0, read);
                System.out.println("read : " +read);
                value = new String(byteArrayOutputStream.toByteArray());
                System.out.println("value : " +value);
                size+=read;
            }
            System.out.println(" 1 " + read);
            System.out.println(" 2 " + size);
            System.out.println(" 3 " + value);
            System.out.println(" ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileReader.readFile " + file.getName() +" 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("FileReader.readFile " + file.getName() +" read 오류.");
            e.printStackTrace();
        }
        // 2. 읽은 내용을 출력하시오
        // 3. 파일2로 복사해서 내용을 넣으시오



    }

    private void CopyFile(){

        FileInputStream input = null;
        FileOutputStream output = null;

        File file = new File("read_target.txt");

        try {
            input = new FileInputStream("C:/Users/tkwon/src/read_target.txt");
            output = new FileOutputStream(new File("C:/Users/tkwon/src/read_target2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int readBuffer = 0;
        byte[] buffer = new byte[128];
        while (true){
            try {
                if (!((readBuffer = input.read(buffer)) != -1)) break;
                output.write(buffer,0,readBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("파일복사되었다.");
        System.out.println(input);
        System.out.println(output);
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            String str = "";
//
//            byte[] bytesIn = str.getBytes();
//            fos.write(bytesIn);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    public static void main(String [] args) {
        FileReader fileReader = new FileReader();


//        fileReader.CopyFile();
        fileReader.readFile();

        // 파일을 복사해서 저장.
    }
}