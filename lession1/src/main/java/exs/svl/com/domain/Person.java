package exs.svl.com.domain;

import org.springframework.stereotype.Component;

@Component
public class Person {

    private String  Name;
    private int Age;
    public Person(String name, int age){
        Name = name;
        Age = age;
    }
    public String getName() {
        return Name;
    }
    public int getAge() {
        return Age;
    }
    @Override
    public String toString(){
        String output ="";
        output+="\nИмя : " + Name+"\n";
        output+="Возраст : " + Age +"\n";
        return output;
    }
}
