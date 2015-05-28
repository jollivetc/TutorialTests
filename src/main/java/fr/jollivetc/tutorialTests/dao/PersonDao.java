package fr.jollivetc.tutorialTests.dao;


import fr.jollivetc.tutorialTests.domain.Person;
import fr.jollivetc.tutorialTests.exception.PersonNotFindException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonDao {

    private static Map<Integer, Person> repo = new HashMap<Integer, Person>();

    static {
        repo.put(1, new Person(1, "John", "Doe", 42));
        repo.put(2, new Person(1, "Jane", "Doe", 33));

    }

    public Person findById(int id) throws PersonNotFindException {
        Person person = repo.get(id);
        if(person == null) {
            throw new PersonNotFindException();
        }
        return person;
    }

    public Collection<Person> findAll() {
        return repo.values();
    }
}
