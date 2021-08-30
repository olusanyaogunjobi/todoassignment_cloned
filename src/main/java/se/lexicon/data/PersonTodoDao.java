package se.lexicon.data;

import se.lexicon.db.MySQLConnection;

import java.sql.*;

public class PersonTodoDao {

    public static void printOutMatchingAppUsers(String firstName, String lastName){
        String findByName = "SELECT * FROM person WHERE first_name = ?";

        try{
            Connection connection = MySQLConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByName);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(1, lastName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getString(1));
                System.out.println("FIRSTNAME: " + resultSet.getString("first_name"));
                System.out.println("LASTNAME: " + resultSet.getString("last_name"));
                System.out.println();
            }


        } catch (SQLException ex){
            ex.printStackTrace();
        }


    }

    public static void findAndPrintAll(){
        try{
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            String findAll = "SELECT * FROM person";

            ResultSet resultSet = statement.executeQuery(findAll);

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getString(1));
                System.out.println("FIRSTNAME: " + resultSet.getString("first_name"));
                System.out.println("LASTNAME: " + resultSet.getString("last_name"));
                System.out.println();
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }












}
