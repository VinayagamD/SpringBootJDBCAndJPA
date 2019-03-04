package com.vinay.database.jdbc.impl;

import com.vinay.database.constant.QueryConstant;
import com.vinay.database.jdbc.PersonDoa;
import com.vinay.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Description: Implementation class for accessing Person Table
 * @author vinay
 *
 */
@Repository
public class PersonDaoImpl implements PersonDoa {
    private static final Logger LOG = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Autowired
    private JdbcTemplate template;


    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("ID"));
            person.setName(rs.getString("NAME"));
            person.setLocation(rs.getString("LOCATION"));
            person.setBirthDate(rs.getTimestamp("BIRTH_DATE"));
            return person ;
        }
    }
    @Override
    public List<Person> findAll() {
        try {
            LOG.info("Connection Url ->{}", template.getDataSource().getConnection().getMetaData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return template.query(QueryConstant.SELECT_PERSON, new BeanPropertyRowMapper<>(Person.class));
        return template.query(QueryConstant.SELECT_PERSON, new PersonRowMapper());
    }

    @Override
    public Person findById(int id) {
        return template.queryForObject(QueryConstant.SELECT_PERSON_BY_ID, new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public int deleteById(int id) {
        return template.update(QueryConstant.DELETE_PERSON_BY_ID, new Object[]{id});
    }

    @Override
    public int insertPerson(Person person) {
        return template.update(QueryConstant.INSERT_PERSON,
                                new Object[]{
                                        person.getId(),
                                        person.getName(),
                                        person.getLocation(),
                                        new Timestamp(person.getBirthDate().getTime())
                                });
    }

    @Override
    public int updatePerson(Person person) {
        return template.update(QueryConstant.UPDATE_PERSON,
                new Object[]{
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),
                        person.getId()
                });
    }
}
