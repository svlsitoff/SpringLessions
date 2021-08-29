package exs.svl.com.domain;

import java.util.List;

public class Quiz {

    public String getRightAnswer() {
        return RightAnswer;
    }

    private String Question;
    private List<String> Options;
    private String RightAnswer;

    @Override
    public String toString() {
        String output = Question + "\n";
        int count = 0;
        for (var item : Options){
           count++;
           output+=count+" "+item+"\n";
        }
        return output;
    }
    public Quiz(String question, List<String> options, String rightAnswer){
        Question = question;
        Options = options;
        RightAnswer = rightAnswer;
    }

}
