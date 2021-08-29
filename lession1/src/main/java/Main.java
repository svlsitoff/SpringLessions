import exs.svl.com.service.UIService;
import exs.svl.com.service.UIServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String ... args)  {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        UIService service = context.getBean(UIServiceImpl.class);
        service.DisplayQuiz();
        }
}
