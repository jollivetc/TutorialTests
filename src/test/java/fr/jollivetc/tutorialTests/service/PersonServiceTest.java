package fr.jollivetc.tutorialTests.service;

import fr.jollivetc.tutorialTests.dao.PersonDao;
import fr.jollivetc.tutorialTests.domain.Person;
import fr.jollivetc.tutorialTests.exception.PersonNotFindException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonDao personDao;

    @Mock
    private ErreurLogger erreurLogger;

    @Test
    public void shouldReturnPersonReturnedByDao() throws PersonNotFindException {
        Person p = new Person(1, "John", "Doe", 42);
        when(personDao.findById(1)).thenReturn(p);

        Person result = personService.searchPerson(1);

        assertThat(result).isEqualTo(p);
    }

    @Test
    public void shouldLogErreurWhenNoResultFound() throws PersonNotFindException {

        PersonNotFindException exception = new PersonNotFindException();
        when(personDao.findById(42)).thenThrow(exception);

        Person result = personService.searchPerson(42);

        assertThat(result).isNull();
        verify(erreurLogger, times(1)).logErreur(any(Integer.class), eq(exception));
    }
}