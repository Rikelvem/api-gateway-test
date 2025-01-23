package br.com.opbdntr.apigatewaytest.service;

import br.com.opbdntr.apigatewaytest.data.vo.v1.PersonVO;
import br.com.opbdntr.apigatewaytest.mapper.DozerMapper;
import br.com.opbdntr.apigatewaytest.model.Person;
import br.com.opbdntr.apigatewaytest.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.logging.Logger;

import static br.com.opbdntr.apigatewaytest.mapper.DozerMapper.parseListObjects;
import static br.com.opbdntr.apigatewaytest.mapper.DozerMapper.parseObject;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");

        return parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById (Long id) {
        logger.info("Finding by id!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResolutionException("No records found for this ID!"));
        return parseObject(entity, PersonVO.class);
    }

    public PersonVO createPerson (PersonVO person) {
        logger.info("Creating one person!");

        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO updatePerson (PersonVO person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResolutionException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonVO.class);
    }

    public void deletePerson (Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResolutionException("No records found for this add."));
        repository.delete(entity);
    }

}
