package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.create(question);
    }


    @GetMapping("{id}")
    public Question getOneQuestion(@PathVariable Long id){
        return questionService.getOneQuestion(id);
    }

    @GetMapping
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable Long quizId){
        return questionService.getQuestionByQuizId(quizId);
    }
}
