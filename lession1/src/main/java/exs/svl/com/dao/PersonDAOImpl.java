package exs.svl.com.dao;

import exs.svl.com.domain.Person;

import java.util.Scanner;

public class PersonDAOImpl implements PersonDAO{
    @Override
    public Person getPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        String name = scanner.nextLine();
        System.out.println("Введите ваш возраст");
        String strAge = scanner.nextLine();
        int age = 0;
        if(CheckAge(strAge)){
            age = Integer.parseInt(strAge);
        }
        if(name!=null&&age>0){
            Person  person = new Person(name,age);
            return person;
        }
        return null;
    }
    private boolean CheckAge(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
