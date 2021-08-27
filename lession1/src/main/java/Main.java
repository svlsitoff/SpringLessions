import exs.svl.com.domain.Quiz;
import exs.svl.com.service.QuizService;
import exs.svl.com.service.QuizServiceImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String ... args)  {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService service = context.getBean(QuizServiceImpl.class);
        for(Quiz quiz : service.getAllQuestions()){
            System.out.println(quiz.getQuestion());
            for(String item : quiz.getOptions()){
                System.out.println(item);
            }
            System.out.println(quiz.getRightAnswer());
        }

    }
}
