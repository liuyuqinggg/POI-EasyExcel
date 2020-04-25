package com.barron;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    String path = "F:\\IDEA\\POI-easyExcel\\barron-poi\\";
    @Test
    public void testWrite03() throws IOException {


        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("统计表");
        Row row1 = sheet.createRow(0);
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日新增观众");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);
        Row row2 = sheet.createRow(1);
        Cell cellce2l = row2.createCell(0);
        cellce2l.setCellValue("统计时间");
        Cell cellce22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cellce22.setCellValue(time);

        FileOutputStream fileOutputStream = new FileOutputStream(path + "统计表03.xls");
        workbook.write(fileOutputStream);;

        fileOutputStream.close();
        System.out.println("finish");

    }

    @Test
    public void testWrite07() throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("统计表");
        Row row1 = sheet.createRow(0);
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日新增观众");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);
        Row row2 = sheet.createRow(1);
        Cell cellce2l = row2.createCell(0);
        cellce2l.setCellValue("统计时间");
        Cell cellce22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cellce22.setCellValue(time);

        FileOutputStream fileOutputStream = new FileOutputStream(path + "统计表07.xlsx");
        workbook.write(fileOutputStream);;

        fileOutputStream.close();
        System.out.println("finish");

    }

    @Test
    public void testDigData03() throws IOException {
        long begin = System.currentTimeMillis();

        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");

        FileOutputStream fileOutputStream = new FileOutputStream(path + "bigData03.xls");
        workbook.write(fileOutputStream);;

        fileOutputStream.close();
        long end = System.currentTimeMillis();

        System.out.println((double) (end-begin)/1000);
    }

    @Test
    public void testDigData07() throws IOException {
        long begin = System.currentTimeMillis();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");

        FileOutputStream fileOutputStream = new FileOutputStream(path + "bigData07.xlsx");
        workbook.write(fileOutputStream);;

        fileOutputStream.close();
        long end = System.currentTimeMillis();

        System.out.println((double) (end-begin)/1000);
    }

    @Test
    public void testDigData07S() throws IOException {
        long begin = System.currentTimeMillis();

        Workbook workbook = new SXSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");

        FileOutputStream fileOutputStream = new FileOutputStream(path + "bigData07S.xlsx");
        workbook.write(fileOutputStream);

        //清楚临时文件
        ((SXSSFWorkbook) workbook).dispose();
        fileOutputStream.close();
        long end = System.currentTimeMillis();

        System.out.println((double) (end-begin)/1000);
    }

}
