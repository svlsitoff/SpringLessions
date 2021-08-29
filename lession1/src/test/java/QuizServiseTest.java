import exs.svl.com.dao.QuizDAOImpl;
import exs.svl.com.service.QuizService;
import exs.svl.com.service.QuizServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuizServiseTest {

    @Test
    void getSimpleQuiz() {
        QuizDAOImpl dao = new QuizDAOImpl("src/main/resources/quiz.csv");
        QuizService service = new QuizServiceImpl(dao);
        assertEquals(dao.getQuizzes(), service.getAllQuestions());
    }
}
