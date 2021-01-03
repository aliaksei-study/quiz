package com.example.quiz.service;

import com.example.quiz.dto.QuestionDto;
import com.example.quiz.dto.SatisfiedQuestionStatisticsDto;
import com.example.quiz.exception.QuestionNotFoundException;
import com.example.quiz.model.Question;

import java.util.List;

public interface IQuestionService {
    QuestionDto updateQuestion(QuestionDto questionDto, Long id) throws QuestionNotFoundException;
    void deleteQuestion(Long id) throws QuestionNotFoundException;
    Question getQuestionById(Long questionId) throws QuestionNotFoundException;
    List<SatisfiedQuestionStatisticsDto> getSatisfiedQuestionStatistics();
    List<QuestionDto> getQuestions();
    QuestionDto saveQuestion(QuestionDto questionDto);
    List<QuestionDto> getFifteenRandomQuestions();
    void processPlayerQuestions();
}
