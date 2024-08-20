package com.example.SpringBoot_Training.controller;

import com.example.SpringBoot_Training.model.Person;
import com.example.SpringBoot_Training.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PeopleApiController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        Person person = peopleService.findById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        peopleService.insert(person);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long id) {
        if (id > 0) {
            if (peopleService.delete(id)) {
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>("The id is invalid", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestBody Person person) {
        if (peopleService.update(person)) {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
