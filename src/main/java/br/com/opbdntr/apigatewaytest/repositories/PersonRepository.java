package br.com.opbdntr.apigatewaytest.repositories;

import br.com.opbdntr.apigatewaytest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
