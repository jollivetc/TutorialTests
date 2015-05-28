package fr.jollivetc.tutorialTests.dao;


import fr.jollivetc.tutorialTests.domain.Person;
import fr.jollivetc.tutorialTests.exception.PersonNotFindException;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonDaoTest {

    private PersonDao personDao;

    @Before
    public void setUp() {
        personDao = new PersonDao();
    }

    @Test
    public void shouldReturnPersonWhenIdExistInRepo() throws PersonNotFindException {
        Person person = personDao.findById(1);
        assertThat(person.getId()).isEqualTo(1);
        assertThat(person.getFirstName()).isEqualTo("John");
    }

    @Test(expected = PersonNotFindException.class)
    public void shouldThrowExceptionWhenNoPersonIsFound() throws PersonNotFindException {
        personDao.findById(42);
    }

    @Test
    public void shouldReturnListOfPerson() {
        Collection<Person> persons = personDao.findAll();

        assertThat(persons).hasSize(2);
        assertThat(persons).areAtLeast(1, new Condition<Person>(){
            @Override
            public boolean matches(Person value) {
                return value.getAge()==33;
            }
        });
    }
}
