package com.example.quiz.service;

import com.example.quiz.dto.AdminQuestionDto;
import com.example.quiz.dto.QuestionDto;
import com.example.quiz.exception.QuestionNotFoundException;
import com.example.quiz.model.Question;

import java.util.List;

public interface IQuestionService {
    void updateQuestion(QuestionDto questionDto, Long id);
    void deleteQuestion(Long id);
    Question getQuestionById(Long questionId) throws QuestionNotFoundException;
    List<AdminQuestionDto> getQuestions();
    QuestionDto saveQuestion(QuestionDto questionDto);
    List<QuestionDto> getFifteenRandomQuestions();
    void processPlayerQuestions();
}
