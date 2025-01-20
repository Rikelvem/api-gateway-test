package br.com.opbdntr.apigatewaytest.service;

import br.com.opbdntr.apigatewaytest.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById (String id) {

        logger.info("Finding by id!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rikelvem");
        person.setLastName("Silva");
        person.setAddress("São Paulo - SP - Brasil");
        person.setGender("Male");
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Same adress in Brasil " + i);
        person.setGender("Male");
        return person;
    }

}
