package com.cheer.service;

import com.cheer.model.Question;

import java.util.List;

public interface QuestionService {
    int insert(Question question);
    List<Question> getQuestionList();

    List<String> getKey();
}
