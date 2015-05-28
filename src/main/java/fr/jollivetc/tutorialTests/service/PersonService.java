package fr.jollivetc.tutorialTests.service;


import fr.jollivetc.tutorialTests.dao.PersonDao;
import fr.jollivetc.tutorialTests.domain.Person;
import fr.jollivetc.tutorialTests.exception.PersonNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ErreurLogger erreurLogger;

    public Person searchPerson(int id ) {
        Person personById = null;
        try {
            personById = personDao.findById(id);
        } catch (PersonNotFindException e) {
            erreurLogger.logErreur(id, e);
        }
        return personById;
    }
}
