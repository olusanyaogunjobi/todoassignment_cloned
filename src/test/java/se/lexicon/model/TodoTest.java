package se.lexicon.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class TodoTest {
    @Test
    public void successfully_todo(){
        //Arrange
        Person newPerson=new Person("Anton","Lundin","dena.ag@gmail.com");

        int idCounter=0;
        String expectedDescription="cleaning";
        boolean expected=false;
        Person expectedAssignee=newPerson;
        //Act
        Todo testNewToDo=new Todo( "cleaning", true, newPerson);
        //Assert
        assertEquals("cleaning",testNewToDo.getDescription());
        assertEquals(false,testNewToDo.isDone());
        assertEquals(newPerson,testNewToDo.getAssignee());


    }
}