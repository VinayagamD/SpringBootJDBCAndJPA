package com.vinay.database;

import com.vinay.database.jpa.PersonJpaRepository;
import com.vinay.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(JPADemoApplication.class);

    @Autowired
    PersonJpaRepository jpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("User id 10001 -> {} ",jpaRepository.findById(10001));
        logger.info("Insert 10004 -> {} ",jpaRepository.insert(
                new Person("TARA", "Berlin", new Date())
        ));
        logger.info("Update 10003 -> {} ",jpaRepository.update(
                new Person(10003,"JohnDoe", "Berlin", new Date())
        ));
        jpaRepository.delete(10002);
        logger.info("All users -> {} ", jpaRepository.findAll());
    }
}
