package fr.jollivetc.tutorialTests.service;


import fr.jollivetc.tutorialTests.exception.PersonNotFindException;
import org.springframework.stereotype.Service;

@Service
public class ErreurLogger {

    public void logErreur(int id, PersonNotFindException ex){
        System.out.println("no Person found for id : " + id);
    }

}
