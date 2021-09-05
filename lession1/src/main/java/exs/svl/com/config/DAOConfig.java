package exs.svl.com.config;

import exs.svl.com.dao.PersonDAO;
import exs.svl.com.dao.PersonDAOImpl;
import exs.svl.com.dao.QuizDAO;
import exs.svl.com.dao.QuizDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {
    @Bean
    PersonDAO personDAO(){
        return new PersonDAOImpl();
    }
    @Bean
    QuizDAO quizDAO(){
        return new QuizDAOImpl();
    }
}
