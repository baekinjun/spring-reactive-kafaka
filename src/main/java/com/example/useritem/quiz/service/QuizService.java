package com.example.useritem.quiz.service;


import com.example.useritem.quiz.domain.Quiz;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();
}
