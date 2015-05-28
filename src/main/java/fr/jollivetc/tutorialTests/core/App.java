package fr.jollivetc.tutorialTests.core;


import fr.jollivetc.tutorialTests.domain.Person;
import fr.jollivetc.tutorialTests.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("fr.jollivetc");
        context.refresh();

        PersonService personService= context.getBean("personService", PersonService.class);

        Person person = personService.searchPerson(1);
        System.out.println("found for id 1 : "+person);

        person = personService.searchPerson(4);
        System.out.println("found for id 4 : "+person);

    }
}
