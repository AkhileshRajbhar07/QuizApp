package com.question.service;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {
    Question create(Question question);
    List<Question> getAllQuestions();
    Question getOneQuestion(Long id);
    List<Question> getQuestionByQuizId(Long id);
}
