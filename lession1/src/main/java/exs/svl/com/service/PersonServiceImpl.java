package exs.svl.com.service;

import exs.svl.com.dao.PersonDAO;
import exs.svl.com.domain.Person;

public class PersonServiceImpl implements PersonService {

    private Person person;
    public PersonServiceImpl(PersonDAO dao){
        person = dao.getPerson();
    }

    @Override
    public Person getPerson() {
        return person;
    }

}
