package com.polestarhc.JSON;

import java.io.*;

public class ReadByte {

    public static void main(String [] args) {
        ReadByte readByte = new ReadByte();

        // 1바이트 읽어오기 실행
        readByte.readFile();

        // 0바이트 60초동안 실행
//        readByte.writeZeroByte();
    }

    private void readFile() {
        File file = new File("study4/testDCM.dcm");
        boolean status = file.exists();
        System.out.println("ReadByte.readFile : " + status +", " + file.getAbsolutePath());

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            // 1바이트씩 읽어옵니다.
            byte[] bytesIn = new byte[1];
            int read = 0;
            long size = 0;
            String value = null;
            while ((read = fis.read(bytesIn)) != -1) {
                byteArrayOutputStream.write(bytesIn, 0, read);
                System.out.println("read : " +read);
                value = new String(byteArrayOutputStream.toByteArray());
                System.out.println("value : " +value);
                size+=read;

                // 100번보다 넘게 돌아가면 멈추기
                if (size > 100){
                    System.out.println("size : " + size);
                    break;
                }

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
    }

    public void writeZeroByte(){

        byte BYTE = 0;
        int second = 0;
        int n = 0;

        // BYTE값 출력
        System.out.println(BYTE);

        // FileOutputStream
        try {
            FileOutputStream fos = new FileOutputStream("study4/60초.txt");

            while(second < 60) {

                fos.write(BYTE);
                fos.flush();
                second = second + 1;
                System.out.println("기록중입니다." + second);
                Thread.sleep(1000);
            }

            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("종료");

    }

}