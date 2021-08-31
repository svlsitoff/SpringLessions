package exs.svl.com.service;

import exs.svl.com.dao.QuizDAO;
import exs.svl.com.domain.Quiz;

import java.util.List;

public class QuizServiceImpl implements QuizService {

    private List<Quiz> Quizzes;

    public QuizServiceImpl(QuizDAO dao){

        Quizzes = dao.getQuizzes();
    }
    @Override
    public List<Quiz> getAllQuestions() {
        return Quizzes;
    }
}
