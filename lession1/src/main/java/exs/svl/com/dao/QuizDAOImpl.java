package exs.svl.com.dao;

import exs.svl.com.domain.Quiz;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class QuizDAOImpl implements QuizDAO {

    private  String path;
    public QuizDAOImpl(String path) {
       this.path = path;
    }

    @Override
    public List<Quiz> readQuiz()  {
        List<String> opts = new ArrayList<>();
        List<Quiz> quizzes = new ArrayList<>();
        try(Reader reader = new FileReader(path);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            for(CSVRecord record : csvParser) {
                String question = record.get("Questions");
                String option1 = record.get("Option 1");
                opts.add(option1);
                String option2 = record.get("Option 2");
                opts.add(option2);
                String option3 = record.get("Option 3");
                opts.add(option3);
                String rightAnswer = record.get("Right option");
                int right = Integer.parseInt(rightAnswer);
                Quiz quiz = new Quiz(question,opts,right);
                quizzes.add(quiz);
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
}
