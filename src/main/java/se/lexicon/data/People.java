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
    public String[]  findById(int personId){
        if(persons.contains(personId))

   }
    public void clear(){
         Arrays.fill(persons, null);
         System.out.println(Arrays.toString(persons));
}




}
