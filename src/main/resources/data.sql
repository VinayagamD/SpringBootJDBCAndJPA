/*
create table person(
  id integer not null ,
  name varchar(255) not null ,
  location varchar(255) ,
  birth_date timestamp,
  primary key (id)
);
*/

INSERT INTO PERSON(id, name, location, birth_date)
  VALUES
         ( 10001, 'Vinay', 'Bangalore', sysdate() ),
         ( 10002, 'James', 'New York', sysdate() ),
         ( 10003, 'Peter', 'Amsterdam', sysdate() );
