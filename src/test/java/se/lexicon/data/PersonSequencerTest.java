package se.lexicon.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonSequencerTest {

    @Test
    public void nextPersonId() {
        //Arrange
        int personId=0;
        int expectedPersonId=1;
        //Act
        personId=personId+1;
        //Assert
        assertEquals(1,personId);
    }

    @Test
    public void reset() {
        //Arrange
        int personId;
        int expectedPersonId=0;
        //Act
        personId=0;
        //Assert
        assertEquals(0,personId);
    }
}