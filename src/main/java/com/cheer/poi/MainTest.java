package com.cheer.poi;


import com.cheer.service.impl.QuestionServiceImpl;
import com.cheer.model.Question;


import java.util.List;

public class MainTest {

    public void uploadExcel(String src){
        QuestionServiceImpl questionService=new QuestionServiceImpl ();
        // 设定Excel文件所在路径
        String excelFileName = src;
        // 读取Excel文件内容
        List<Question> readResult = ExcelReader.readExcel(excelFileName);

        for(Question a:readResult){
            questionService.insert (a);
        }
    }
}