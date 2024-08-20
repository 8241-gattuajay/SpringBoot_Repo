package com.example.SpringBoot_Training.service;

import com.example.SpringBoot_Training.model.Person;
import com.example.SpringBoot_Training.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PeopleService {

    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> findAllPeople() {
        return (List<Person>) repository.findAll();
    }

    @Override
    public Person insert(Person p) {
        return repository.save(p);
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            // Use a logger instead of System.out.println
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Person findById(long id) {
        Optional<Person> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public boolean update(Person p) {
        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            // Use a logger instead of System.out.println
            System.err.println(e.getMessage());
            return false;
        }
    }
}
