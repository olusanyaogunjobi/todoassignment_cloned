package se.lexicon.data;

import se.lexicon.model.Person;

import java.*;

import java.util.Collection;

public interface PeopleDao {
    Person create (Person person);
    Collection<Person> findAll();
    Person findById(int personId);
    Collection<Person> findByName(String firstName, String lastName) ;
    Person update(Person person);
    boolean deleteById(int personId);




}
