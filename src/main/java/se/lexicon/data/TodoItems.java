package se.lexicon.data;

import se.lexicon.db.MySQLConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItems implements TodoItemsDao {


    @Override
    public Todo create(Todo todo) {
        String createSQL = "INSERT INTO todo_item (todo_id, title, description, deadline, done, assignee_id) VALUES (?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rowsAffected = 0;
        Todo createdTodo = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            LocalDate time = LocalDate.now();

            preparedStatement = connection.prepareStatement(createSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, todo.getTodoId());
            preparedStatement.setString(2, todo.getTitle());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setObject(4, todo.getDeadline());
            preparedStatement.setBoolean(5, todo.isDone());
            preparedStatement.setObject(6, todo.getAssignee().getPersonId());

            rowsAffected = preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                todo.setTodoId(resultSet.getInt(1));
            }

        }
        catch (SQLIntegrityConstraintViolationException exception){
            System.out.println("Can Not Create: Violation of Constraint");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return todo;
    }

    @Override
    public Collection<Todo> findAll() {

        Collection<Todo> todoItemFound = new ArrayList<>();

        String findAll = "SELECT * FROM todo_item";
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

            while (resultSet.next()) {

                todoItemFound.add(
                        new Todo(
                                resultSet.getInt("todo_id"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getObject(4, LocalDate.class),
                                resultSet.getBoolean("done"),
                                resultSet.getObject(6, "assignee_i")

                        )

                );
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }

        return todoItemFound;
    }

    @Override
    public Todo findById(int todoId) {
        Todo todoItemFound = null;
        String findById = "SELECT * FROM todo_item WHERE todo_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setInt(1, todoId;

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                todoItemFound = new Person(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.,
                        resultSet.getString("deadline")

                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personFound;
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int personId) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems(int todoId) {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int personId) {
        return false;
    }


}



