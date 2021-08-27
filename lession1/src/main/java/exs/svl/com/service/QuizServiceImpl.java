package exs.svl.com.service;

import exs.svl.com.dao.QuizDAO;
import exs.svl.com.domain.Quiz;

import java.util.List;

public class QuizServiceImpl implements QuizService {

    private List<Quiz> Quizzes;

    public QuizServiceImpl(QuizDAO dao){
        Quizzes = dao.readQuiz();
    }

    @Override
    public Quiz getByQuestion(String question) {
        Quiz need = Quizzes.stream()
                .filter(quiz -> question.equals(quiz.getQuestion()))
                .findAny()
                .orElse(null);

        return need;
    }

    @Override
    public List<Quiz> getAllQuestions() {
        return Quizzes;
    }
}
