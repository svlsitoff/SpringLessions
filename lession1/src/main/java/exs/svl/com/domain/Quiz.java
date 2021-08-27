package exs.svl.com.domain;

import java.util.List;

public class Quiz {

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public List<String> getOptions() {
        return Options;
    }

    public void setOptions(List<String> options) {
        Options = options;
    }

    public int getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        RightAnswer = rightAnswer;
    }

    private String Question;
    private List<String> Options;
    private int RightAnswer;

    public Quiz(String question,List<String> options,int rightAnswer){
        Question = question;
        Options = options;
        RightAnswer = rightAnswer;
    }

}
