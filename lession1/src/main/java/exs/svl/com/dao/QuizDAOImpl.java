package exs.svl.com.dao;

import com.opencsv.CSVReader;
import exs.svl.com.domain.Quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAOImpl implements QuizDAO {

    public List<Quiz> getQuizzes()  {
        List<String> opts = new ArrayList<>();
        List<Quiz> quizzes = new ArrayList<>();
        InputStream is = getFromFile();
            try(CSVReader reader = new CSVReader(new InputStreamReader(is))) {
                String[] nextRecord;
                while( (nextRecord = reader.readNext())!=null) {
                    String question = nextRecord[0];
                    String option1 = nextRecord[1];
                    opts.add(option1);
                    String option2 = nextRecord[2];
                    opts.add(option2);
                    String option3 = nextRecord[3];
                    opts.add(option3);
                    String rightAnswer = nextRecord[4];
                    List<String> dest =  new ArrayList<String>();
                    dest.addAll(opts);
                    Quiz quiz = new Quiz(question,dest,rightAnswer);
                    quizzes.add(quiz);
                    opts.clear();
                }
            }catch (IOException ex){
                System.out.println("Cannot open file by specify path");
            }catch (Exception ex){
                System.out.println("Cannot to read specify file");
            }
            if(quizzes.size()>0){
               return quizzes;
            }
            return null;
    }

    private InputStream getFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("quiz.csv");

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + "quiz.csv");
        } else {
            return inputStream;
        }
    }
}
