import exs.svl.com.domain.Quiz;
import exs.svl.com.service.QuizService;
import exs.svl.com.service.QuizServiceImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String ... args)  {

        //loading context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        //create service
        QuizService service = context.getBean(QuizServiceImpl.class);
        //from service get list quiz
        for(Quiz quiz : service.getAllQuestions()){
            System.out.println(quiz.getQuestion());
            for(String item : quiz.getOptions()){
                System.out.println(item);
            }
            System.out.println(quiz.getRightAnswer());
        }

    }
}
