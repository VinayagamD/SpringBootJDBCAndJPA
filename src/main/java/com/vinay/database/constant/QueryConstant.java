package com.vinay.database.constant;

public interface QueryConstant {
    String SELECT_PERSON = "SELECT * FROM PERSON;";
    String SELECT_PERSON_BY_ID = "SELECT * FROM PERSON WHERE ID = ?;";
    String DELETE_PERSON_BY_ID = "DELETE FROM PERSON WHERE ID = ?;";
    String INSERT_PERSON ="INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES(?,?,?,?);";
    String UPDATE_PERSON= "UPDATE PERSON SET NAME =? , LOCATION =?, BIRTH_DATE = ? WHERE ID = ?;";
}
