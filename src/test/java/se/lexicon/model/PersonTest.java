package se.lexicon.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {




    @Test
   public void successfully_created(){
        //Arrange
        int counter=0;
        Person test=null;
        String expectedFirstName="testName";
        String expectedLastName="testLastName";
        String expectedEmail="d.ag@gmail.com";
        int personId=++counter;
        //Act
        Person testObject=new Person("testName","testLastName","d.ag@gmail.com");
        //Assert
        assertEquals("testName",testObject.getFirstName());
        assertEquals("testLastName",testObject.getLastName());
        assertEquals("d.ag@gmail.com",testObject.getEmail());
        System.out.println("person ID is:"+Person.counter);

    }
}