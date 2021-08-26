package com.example.useritem.quiz.controller;

import com.example.useritem.quiz.domain.Quiz;
import com.example.useritem.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    //리액티브 방식
    @GetMapping("/random")
    public ResponseEntity<Mono<Quiz>> getQuiz() {
        return ResponseEntity.ok(quizService.createQuiz());
    }
}
