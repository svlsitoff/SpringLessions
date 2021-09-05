import exs.svl.com.service.UIService;
import exs.svl.com.service.UIServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("exs.svl.com.config")
public class Main {

    public static void main(String ... args)  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        UIService service = context.getBean(UIServiceImpl.class);
        service.DisplayQuiz();
        }
}
