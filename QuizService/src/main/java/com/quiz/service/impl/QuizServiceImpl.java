package com.quiz.service.impl;

import com.quiz.dao.QuizDao;
import com.quiz.entities.Quiz;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizDao quizDao;
    private final QuestionClient questionClient;

    public QuizServiceImpl(QuizDao quizDao, QuestionClient questionClient) {
        this.quizDao = quizDao;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return quizDao.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizList = quizDao.findAll();
        return quizList.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {

        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
