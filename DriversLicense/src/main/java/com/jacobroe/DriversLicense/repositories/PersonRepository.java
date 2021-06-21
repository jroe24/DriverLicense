package com.jacobroe.DriversLicense.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.jacobroe.DriversLicense.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}