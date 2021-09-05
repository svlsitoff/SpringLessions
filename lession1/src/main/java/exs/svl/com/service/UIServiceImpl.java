package exs.svl.com.service;

import exs.svl.com.domain.Person;
import exs.svl.com.domain.Quiz;

import java.util.List;
import java.util.Scanner;
public class UIServiceImpl implements UIService {

    private List<Quiz> Quizzes;
    private Person person;
    private int  correctAnswers;
    public UIServiceImpl(QuizService quizService, PersonService personService){
        this.Quizzes = quizService.getAllQuestions();
        this.person = personService.getPerson();
    }
    @Override
    public void DisplayQuiz() {
        try{
            for(var item : Quizzes){
                System.out.println(item.toString());
                System.out.println("Ваш ответ :");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if(answer.equals(item.getRightAnswer())){
                    correctAnswers++;
                }
            }
            Finish();
        }catch (NullPointerException ex){
            System.out.println("Не удалось корректно прочитать файл");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void Finish(){
        System.out.println("Участник тестирования :" +person.toString() );
        System.out.println("Вы дали "+correctAnswers + " правильных ответов из "+Quizzes.size());

    }
}
