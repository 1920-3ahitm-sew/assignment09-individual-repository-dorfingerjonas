package at.htl.jdbcrepository.entity;

public interface Repository {
    public Person save(Person p);
    public void delete(long id);
}
