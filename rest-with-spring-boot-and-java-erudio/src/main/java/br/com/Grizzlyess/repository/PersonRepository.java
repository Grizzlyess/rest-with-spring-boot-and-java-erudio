package br.com.Grizzlyess.repository;

import br.com.Grizzlyess.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
