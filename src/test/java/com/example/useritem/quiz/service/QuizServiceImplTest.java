package com.example.useritem.quiz.service;

import com.example.useritem.quiz.domain.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {
    //데이터 받는 부분은 목객체 생성 x
    private QuizServiceImpl quizService;

    //데이터 공급해주는 부분이 목객체 생성
    @Mock
    GeneratorServiceImpl generatorService;

    @BeforeEach
    void setUp() {
        quizService = new QuizServiceImpl(generatorService);
    }

    @Test
    @DisplayName("50 * 30 = 1500")
    void createQuiz() {
        //목객체에 데이터 주입
        given(generatorService.randomFactor()).willReturn(50, 30);

        Mono<Quiz> quiz = quizService.createQuiz();
        Quiz q = quiz.block();
        assertThat(q.getFactorA(), is(50));
        assertThat(q.getFactorB(), is(30));
        assertThat(q.getResult(), is(1500));
    }
}