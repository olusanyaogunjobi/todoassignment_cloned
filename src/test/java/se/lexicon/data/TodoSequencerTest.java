package se.lexicon.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class TodoSequencerTest {

    @Test
    public void nextTodoId() {
        //Arrange
        int toDoId=0;
        int expectedPersonId=1;
        //Act
        toDoId=toDoId+1;
        //Assert
        assertEquals(1,toDoId);


    }

    @Test
    public void reset() {
        //Arrange
        int toDoId;
        int expectedToDoId=0;
        //Act
        toDoId=0;
        //Assert
        assertEquals(0,toDoId);


    }
}