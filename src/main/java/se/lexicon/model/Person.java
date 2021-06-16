package se.lexicon.model;

public class Person {
    public static int counter=0;

    private int personId;
    private String firstName;
    private String lastName;

    public Person( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        personId=++counter;

    }

    public void setId(int id) {
        this.personId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
