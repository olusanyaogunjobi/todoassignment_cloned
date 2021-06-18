package se.lexicon.model;

public class Person {
    public static int counter=0;

    private int personId;
    private String firstName;
    private String lastName;
    private String email;


    public Person( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        personId=++counter;
    }

    public Person( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
//    public Person findById(int personId){
//        if(this.personId==personId)
//        return Person;
//    }


    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    public void clear(){

    }
}
