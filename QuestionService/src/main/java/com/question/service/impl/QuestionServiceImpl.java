package com.question.service.impl;

import com.question.dao.QuestionDao;
import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Question create(Question question) {
        return questionDao.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public Question getOneQuestion(Long id) {
        return questionDao.findById(id).orElseThrow(()->new RuntimeException("Question not found !"));
    }

    @Override
    public List<Question> getQuestionByQuizId(Long id) {
        return questionDao.findByQuizId(id);
    }

}
