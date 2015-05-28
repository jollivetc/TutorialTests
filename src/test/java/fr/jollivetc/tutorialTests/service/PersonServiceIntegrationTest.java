package fr.jollivetc.tutorialTests.service;


import fr.jollivetc.tutorialTests.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/test/resources/applicationContext.xml"})
public class PersonServiceIntegrationTest {

    @Autowired
    private PersonService personService;


    @Test
    public void shouldReturnPersonWhenFound() {
        Person person = personService.searchPerson(1);
        assertThat(person.getFirstName()).isEqualTo("John");

    }

    @Test
    public void shouldReturnNullWhenNotFound() {
        Person person = personService.searchPerson(42);
        assertThat(person).isNull();

    }

}