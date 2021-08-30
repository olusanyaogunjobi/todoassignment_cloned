package se.lexicon;

import se.lexicon.data.TodoItems;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.sql.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {

    /*private static final String URL = "jdbc:mysql://localhost:3306/todoit";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
*/
    public static void main(String[] args) {

        //Create Book Locally in java program

        //Persisting to DataBase


        //Print out
        System.out.println();






        /*try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String findAll = " SELECT FROM * person";
            ResultSet resultSet = statement.executeQuery(findAll);

            while (resultSet.next()) {

                System.out.println("ID:" + resultSet.getString(1));
                System.out.println("FIRSTNAME:" + resultSet.getString("firstname"));
                System.out.println("LASTNAME:" + resultSet.getString("lastname"));
                System.out.println("EMAIL:" + resultSet.getString("email"));
                System.out.println();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/
        /*Person p=new Person("Dena","Aghajari");
        System.out.println("person ID is:"+Person.counter);
        System.out.println(p);

        Person newPerson=new Person("Anton","Lundin","dena.ag@gmail.com");
        System.out.println("person ID is:"+Person.counter);
        System.out.println(newPerson);

        Todo newToDo=new Todo( "Java lecture", true,newPerson );
        System.out.println("toDo ID is:"+Todo.idCounter);
*/


    }
}





