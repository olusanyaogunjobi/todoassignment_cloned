package se.lexicon.data;

import se.lexicon.db.MySQLConnection;
import se.lexicon.model.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class People implements PeopleDao{


    @Override
    public Person create(Person person) {
        String createSQL = "INSERT INTO person (person_id, first_name, last_name) VALUES (?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rowsAffected = 0;
        Person createdPerson = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            LocalDate time = LocalDate.now();

            preparedStatement = connection.prepareStatement(createSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, person.getPersonId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());


            rowsAffected = preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                person.setPersonId(resultSet.getInt(1));
            }

        }
        catch (SQLIntegrityConstraintViolationException exception){
            System.out.println("Can Not Create: Violation of Constraint");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



        return person;
    }

    @Override
    public Collection<Person> findAll() {

        //preparing
        Collection<Person> personFound = new ArrayList<>();

        String findAll = "SELECT * FROM person";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            //Establish Connection with Database.
            connection = MySQLConnection.getInstance().getConnection();

            // Prepare request statement to Database.
            preparedStatement = connection.prepareStatement(findAll);

            //Execute request statement to the Database. (Commit)
            // Gets the Result as a set.
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                personFound.add(
                        new Person(
                                resultSet.getInt("person_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")

                        )
                );

            }

        } catch (SQLException exception){
            exception.printStackTrace();
        }

        return personFound;

    }

    @Override
    public Person findById(int personId) {

        Person personFound = null;
        String findById = "SELECT * FROM person WHERE person_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setInt(1, personId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                personFound = new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")

                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personFound;
    }

    @Override
    public Collection<Person> findByName(String firstName, String lastName) {

        Collection<Person> personFound = new ArrayList<>();

        String findByFirstName = "SELECT * FROM person WHERE first_name LIKE ?";
        String findByLastName = "SELECT * FROM person WHERE last_name LIKE ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(findByFirstName);
            preparedStatement = connection.prepareStatement(findByLastName);
            // ex. Narnia%
            preparedStatement.setString(1, firstName + "%");
            preparedStatement.setString(1, lastName + "%");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                personFound.add(
                        new Person(
                                resultSet.getInt("person_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personFound;
    }

    @Override
    public Person update(Person person) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        Person updatedPerson = null;

        try{
            connection = MySQLConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("UPDATE person SET person_id =?, first_name = ?, last_name = ?");
            preparedStatement.setInt(1, person.getPersonId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }


        if (rowsAffected >= 1){
            return person;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteById(int personId) {
        String deleteById = "DELETE FROM person WHERE person_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean wasDeleted = false;

        try {
            connection = MySQLConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(deleteById);
            preparedStatement.setInt(1, personId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wasDeleted;

    }

}
