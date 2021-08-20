package com.polestarhc.excel;

import com.polestarhc.thread.Study;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteStudy {

    private static final String FILE_NAME = "MySecondExcel.xlsx";
    private String[] headers = {"PatientId", "PatientName"};
    private String[] titles = {"환자번호", "환자이름"};


    public void makeExcel(List<IExcel> list) {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");

        Object[][] datatypes =
                {
//                        {"DataType", "Type", "Size(in bytes)"},
                };
//        for (int i=0; i < 10 ; i++){
//            for(int j = 0 ; j < 10 ; j++){
//                System.out.println("i값은 : " + i);
//                System.out.println("j값은 : " + j);
//            }
//        }

        int rowNum = 0;
        System.out.println("Creating excel");
//
//        for (Object[] datatype : datatypes) {
//            Row row = sheet.createRow(rowNum++);
//            int colNum = 0;
//            for (Object field : datatype) {
//                Cell cell = row.createCell(colNum++);
//
//                if (field instanceof String) {
//                    cell.setCellValue((String) field);
//                } else if (field instanceof Integer) {
//                    cell.setCellValue((Integer) field);
//                }
//            }
//        }
//

        // Test Code


        Row row = sheet.createRow(rowNum++);
        int colNum = 0;

        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(colNum++);
            cell.setCellValue(titles[i]);

        }


        for (int i = 0; i < list.size(); i++) {
            colNum = 0;

            Row row2 = sheet.createRow(rowNum++);

            IExcel excel = list.get(i);
            Cell cell = row2.createCell(colNum++);
            cell.setCellValue(excel.getValue(headers[colNum - 1]));

            Cell cell2 = row2.createCell(colNum++);
            cell2.setCellValue(excel.getValue(headers[colNum - 1]));

        }


        // Test Code End

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }

    public static void main(String[] args) {

        List<IExcel> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Study study = new Study();

            study.setPatiendId("PID" + i);
            study.setPatientName("Name" + i);
            list.add(study);
        }


        ExcelWriteStudy ews = new ExcelWriteStudy();
        ews.makeExcel(list);


    }


}