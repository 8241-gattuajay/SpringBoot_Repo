package com.example.SpringBoot_Training.service;

import com.example.SpringBoot_Training.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PeopleService {
    List<Person> findAllPeople();
    Person findById(long id);
    Person insert(Person p);
    boolean delete(long id);
    boolean update(Person p);
}
