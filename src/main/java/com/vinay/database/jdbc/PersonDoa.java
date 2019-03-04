package com.vinay.database.jdbc;

import com.vinay.database.model.Person;

import java.util.List;

public interface PersonDoa {

    List<Person>  findAll();

    Person findById(int id);

    int deleteById(int id);

    int insertPerson(Person person);

    int updatePerson(Person person);
}
