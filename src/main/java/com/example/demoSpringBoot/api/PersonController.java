package com.example.demoSpringBoot.api;

import com.example.demoSpringBoot.model.Person;
import com.example.demoSpringBoot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping("{id}")
    public int deletePersonById(@PathVariable("id") UUID id) {
        return personService.deletePersonById(id);
    }

    @PutMapping("{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        return personService.updatePersonById(id, personToUpdate);
    }
}
