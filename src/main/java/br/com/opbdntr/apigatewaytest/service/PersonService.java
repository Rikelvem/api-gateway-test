package br.com.opbdntr.apigatewaytest.service;

import br.com.opbdntr.apigatewaytest.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

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

}
