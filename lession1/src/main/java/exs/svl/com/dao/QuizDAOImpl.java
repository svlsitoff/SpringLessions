package exs.svl.com.dao;

import com.opencsv.CSVReader;
import exs.svl.com.domain.Quiz;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
public class QuizDAOImpl implements QuizDAO {

    InputStream is;
    private List<Quiz> Quizzes;
    public QuizDAOImpl() {

        try {
            is = this.getFileFromResourceAsStream("quiz.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        read();
    }

    public void read()  {
        List<String> opts = new ArrayList<>();
        List<Quiz> quizzes = new ArrayList<>();

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
                Quizzes = quizzes;
            }


    }
    @Override
    public List<Quiz> getQuizzes() {
        return Quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        Quizzes = quizzes;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
    private  void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
