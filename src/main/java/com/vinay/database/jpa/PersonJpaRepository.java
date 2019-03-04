package com.vinay.database.jpa;

import com.vinay.database.model.Person;

import java.util.List;

public interface PersonJpaRepository {

    List<Person> findAll();
    Person findById(int id);
    Person update(Person person);
    Person insert(Person person);
    void delete(int id);
}
