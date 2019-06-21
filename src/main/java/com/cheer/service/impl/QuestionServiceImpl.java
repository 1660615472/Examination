package com.cheer.service.impl;

import com.cheer.dao.QuestionMapper;
import com.cheer.model.Question;
import com.cheer.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    QuestionMapper questionMapper = new QuestionMapperImpl ();

    @Override
    public int insert(Question question) {
        int i = questionMapper.insertQuestion ( question );
        if (i > 0) {
            System.out.println ( "插入成功!" );
        } else {
            System.out.println ( "插入失败!" );
        }
        return i;
    }

    @Override
    public List<Question> getQuestionList() {
        List<Question> subjectList=questionMapper.getQuestionList ();
        return  subjectList;
    }



    @Override
    public List<String> getKey() {
        List<String> keyList=questionMapper.getKey ();
        return keyList;
    }
}
