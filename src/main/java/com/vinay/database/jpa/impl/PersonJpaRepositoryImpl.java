package com.vinay.database.jpa.impl;

import com.vinay.database.jpa.PersonJpaRepository;
import com.vinay.database.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepositoryImpl implements PersonJpaRepository {
    // connect to database
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Person> findAll() {
        TypedQuery<Person>  namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    @Override
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public Person update(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public void delete(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
