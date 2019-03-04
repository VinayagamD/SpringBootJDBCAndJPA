package com.vinay.database;

import com.vinay.database.jdbc.PersonDoa;
import com.vinay.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonDoa personDoa;


    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      /*  logger.info("All users -> {}", personDoa.findAll());
        logger.info("User id 10001->{} ", personDoa.findById(10001));
        logger.info("DELETING 10002-> No of Rows Deleted - {} ", personDoa.deleteById(10002));
        logger.info("Insert 10005 -> {} ",personDoa.insertPerson(
                new Person(10005,"TARA", "Berlin", new Date())
        ));
        logger.info("Update 10003 -> {} ",personDoa.updatePerson(
                new Person(10003,"TARA", "Berlin", new Date())
        ));*/
    }
}
