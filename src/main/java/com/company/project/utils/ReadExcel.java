package com.company.project.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        //读取数据流
        FileInputStream fileInputStream = new FileInputStream("D:\\文件\\student.xls");
        //解析
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

        int size = xssfWorkbook.getNumberOfSheets();

        System.out.println("sheet个数为"+size);

        //循环处理读取每一个工作表中的数据
        for(int i = 0; i<size;i++){
            XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
            System.out.println("读取当前工作表名称："+sheet.getSheetName());
            //得到有效行数
            int rowNumber = sheet.getPhysicalNumberOfRows();

            System.out.println("有效行数"+ rowNumber);

            for (int row = 0; row < rowNumber; row++) {
                System.out.println("正在读取第"+row+"行");
                if (row == 0) {
                    continue;
                }
                XSSFRow rowData = sheet.getRow(row);

                for (int cellIndex = 0; cellIndex < 3 ; cellIndex++) {
                    XSSFCell cell = rowData.getCell(cellIndex);
                    System.out.println("列值："+cell);
                }

            }

        }

    }
}
