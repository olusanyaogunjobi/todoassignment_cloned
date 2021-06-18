package se.lexicon.data;

import se.lexicon.model.Person;

import java.util.Arrays;

public class People {


    private static  Person[] persons = new Person[0];


    public int getSize() {
        return persons.length;
    }
    public Person[] findAll(String[] names){
        Person[] Person2= Arrays.copyOf(People.persons, People.persons.length);
        System.out.println(Arrays.toString(Person2));
        return Person2;
    }


    // who's id do we want to find?
    // Checking all persons in the array if id matches.
    // return if you found it.
    public Person findById(int personId){

        for(Person person:persons){
            if(person.getId()==personId){
                return person;
            }
        }

        return null;
  }

    public void clear(){
         Arrays.fill(persons, null);
         System.out.println(Arrays.toString(persons));
}




}
