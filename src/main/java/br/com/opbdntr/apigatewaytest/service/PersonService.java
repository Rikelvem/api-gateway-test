package br.com.opbdntr.apigatewaytest.service;

import br.com.opbdntr.apigatewaytest.model.Person;
import br.com.opbdntr.apigatewaytest.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findById (Long id) {

        logger.info("Finding by id!");

        Person person = new Person();
        person.setFirstName("Rikelvem");
        person.setLastName("Silva");
        person.setAddress("São Paulo - SP - Brasil");
        person.setGender("Male");
        return repository.findById(id)
                .orElseThrow(() -> new ResolutionException("No records found for this ID!"));
    }

    public Person createPerson (Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person updatePerson (Person person) {
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResolutionException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void deletePerson (Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResolutionException("No records found for this add."));
        repository.delete(entity);
    }

}
