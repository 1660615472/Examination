/*
package com.cheer.service;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
*/
/*
* 解析excel生成list的类
* *//*

import static org.apache.poi.ss.usermodel.Cell.*;

public class WorkBooks {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = new WorkBooks ().readBook ();
        List<String> list = map.get ( 1 );//这里返回的list里包含了所有的题目答案
        */
/*for(String s:list){
            System.out.println(s);
        }*//*

       */
/* List<Subject> subjectList = new ArrayList<> ();
        Subject subject = null;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet ()) {
            subject = new Subject ();
            subjectList.add ( subject );
            for (int i = 0; i < entry.getValue ().size (); i++) {
                switch (i) {
                    case 0:
                        subject.setQuestion ( entry.getValue ().get ( i ) );

                        System.out.println(entry.getValue ().get ( i ));
                        break;
                    case 1:
                        subject.setA ( entry.getValue ().get ( i ) );
                        break;
                    case 2:
                        subject.setB ( entry.getValue ().get ( i ) );
                    case 3:
                        subject.setC ( entry.getValue ().get ( i ) );
                    case 4:
                        subject.setD ( entry.getValue ().get ( i ) );
                    case 5:
                        subject.setAnswer ( entry.getValue ().get ( i ) );
                }
            }
            SubjectService subjectService = new SubjectServieLmp ();
       try {
          subjectService.insert ( subject );
       } catch (Exception e) {
            e.printStackTrace ();
       }


        }*//*


    }

    public Map<Integer, List<String>> readBook() {
        FileInputStream file = null;
        try {
            file = new FileInputStream ( new File ( "D:/MYJAVA/题目.xlsx" ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook ( file );
        } catch (IOException e) {
            e.printStackTrace ();
        }
// 打开Excel中的第一个Sheet
        Sheet sheet = workbook.getSheetAt ( 0 );

// 读取Sheet中的数据
        Map<Integer, List<String>> data = new HashMap<> ();
        List<String> list = new ArrayList<> ();
        int i = 0;
        for (Row row : sheet) { // 行
            data.put ( i, list );
            for (Cell cell : row) { // 单元格
                switch (cell.getCellType ()) { // 不同的数据类型
                    case CELL_TYPE_STRING:
                        data.get ( i ).add ( cell.getRichStringCellValue ().getString () );
                        break; // 字符串类型

                    case CELL_TYPE_BOOLEAN:
                        data.get ( i ).add ( String.valueOf ( cell.getBooleanCellValue () ) );
                        break; // 布尔类型
                    case CELL_TYPE_FORMULA:
                        data.get ( i ).add ( cell.getCellFormula () );
                        break; // 公式类型
                    case CELL_TYPE_BLANK:
                        data.get ( i ).add ( "" );
                        break; // 空白类型
                }
            }
            i++;
        }

        return data;

    }
}

*/
