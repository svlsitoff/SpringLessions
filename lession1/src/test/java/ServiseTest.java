import exs.svl.com.dao.QuizDAOImpl;
import exs.svl.com.service.QuizService;
import exs.svl.com.service.QuizServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiseTest {

    @Test
    void getSimpleQuiz() {
        QuizDAOImpl dao = new QuizDAOImpl();
        QuizService service = new QuizServiceImpl(dao);
        assertEquals(dao.getQuizzes(), service.getAllQuestions());
    }
    @Test
    void PersonServise(){

    }
}
