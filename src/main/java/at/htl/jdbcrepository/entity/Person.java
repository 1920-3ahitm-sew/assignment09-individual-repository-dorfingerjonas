package at.htl.jdbcrepository.entity;

public class Person {

    private Long id;
    private String name;
    private String city;
    private String house;

    public Person() {
    }

    public Person(String name, String city, String house) {
        this.name = name;
        this.city = city;
        this.house = house;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
