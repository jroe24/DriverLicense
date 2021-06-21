package com.jacobroe.DriversLicense.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.jacobroe.DriversLicense.models.Person;
import com.jacobroe.DriversLicense.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    public Person getPersonById(Long id) {
        Optional<Person> locatePerson = personRepository.findById(id);
        if(locatePerson.isPresent()) {
            return locatePerson.get();
        } else {
            return null;
        }
    }
}