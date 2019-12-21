package at.htl.jdbcrepository.control;

import at.htl.jdbcrepository.entity.Person;
import at.htl.jdbcrepository.entity.Repository;

import java.sql.*;

public class PersonRepository implements Repository {
    public static final String url = "jdbc:derby://localhost:1527/db;create=true";
    public static final String username = "app";
    public static final String password = "app";

    public void createTable() {
        try (Connection conn = DriverManager.getConnection( // <1>
                url,
                username,
                password)) {
            try (Statement stmt = conn.createStatement()) {  // <1>
                String sql = "CREATE TABLE person (" +
                        "id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY," +
                        "name VARCHAR(255)," +
                        "city VARCHAR(255)," +
                        "house VARCHAR(255)" +
                        ")";
                stmt.executeUpdate(sql);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Person save(Person p) {
        try (Connection conn = DriverManager.getConnection(
                url,
                username,
                password)) {

            String sql = "INSERT INTO person (NAME, CITY, HOUSE) " +
                         "VALUES (?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1,p.getName());
                pstmt.setString(2,p.getCity());
                pstmt.setString(3,p.getHouse());
                int rowAffected = pstmt.executeUpdate();
                System.out.println("Zeilen eingefügt: " + rowAffected);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
