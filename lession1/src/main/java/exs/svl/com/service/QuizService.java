package exs.svl.com.service;

import exs.svl.com.domain.Quiz;

import java.util.List;

public interface QuizService {

    public Quiz getByQuestion(String question);
    public List<Quiz> getAllQuestions();
}
