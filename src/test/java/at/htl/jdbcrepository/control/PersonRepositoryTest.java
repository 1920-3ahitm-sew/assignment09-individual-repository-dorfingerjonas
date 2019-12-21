package at.htl.jdbcrepository.control;

import at.htl.jdbcrepository.entity.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class PersonRepositoryTest {
    @Test
    void test001_createConnection() {
        PersonRepository personRepository = new PersonRepository();
        personRepository.createTable();

    }

    @Test
    void test002_insertRecord() {
        Person jakob = new Person("Jakob", "Bad Leonfelden", "Targaryen");

        PersonRepository personRepository = new PersonRepository();
        personRepository.save(jakob);
    }

}