package exs.svl.com.config;

import exs.svl.com.dao.PersonDAO;
import exs.svl.com.dao.QuizDAO;
import exs.svl.com.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {


    @Bean
    PersonService personService(PersonDAO personDAO){
        return new PersonServiceImpl(personDAO);
    }
    @Bean
    QuizService quizService(QuizDAO quizDAO){
        return new QuizServiceImpl(quizDAO);
    }
    @Bean
    UIService uiService(QuizService quizService, PersonService personService){
        return new UIServiceImpl(quizService, personService);
    }
}
