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
            preparedStatement.setInt(6, todo.getAssignee().getPersonId());

            rowsAffected = preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                todo.setTodoId(resultSet.getInt(1));
            }

        } catch (SQLIntegrityConstraintViolationException exception) {
            System.out.println("Can Not Create: Violation of Constraint");
        } catch (SQLException e) {
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
                                resultSet.getDate(4).toLocalDate(),
                                resultSet.getBoolean("done"),
                                null
                        )
                );
            }
        } catch (SQLException exception) {
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
            preparedStatement.setInt(1, todoId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                todoItemFound = new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean("done"),
                        null
                );
            
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoItemFound;
    }

    @Override
    public boolean findByDoneStatus(boolean done)
    {
        String doneStatus = null;
        String findByDoneStatus = "SELECT * FROM todo_item WHERE done = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(findByDoneStatus);
            preparedStatement.setBoolean(1, done);

            resultSet = preparedStatement.executeQuery();

            //if (resultSet.next()) {
               if (doneStatus.equals(done)){
                new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean("done"),
                        null
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public Collection<Todo> findByAssignee(int personId) {
        Todo todoItemFound = null;
        String findById = "SELECT * FROM todo_item WHERE personId = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setInt(1, personId);

            resultSet = preparedStatement.executeQuery();

            if (todoItemFound.getTodoId()== personId ) {
                new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean("done"),
                        null
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (Collection<Todo>) todoItemFound;

    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        Todo todoItemFound = null;
        String findById = "SELECT * FROM person WHERE assignee_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnection.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setString(1, person.getFirstName());

            resultSet = preparedStatement.executeQuery();

            if (todoItemFound.getAssignee().equals(person) ) {
                new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean("done"),
                        null
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (Collection<Todo>) todoItemFound;


    }

    @Override
    public int findByUnassignedTodoItems(int todoId) {

            Todo todoItemFound = null;
            String findById = "SELECT * FROM todo_item WHERE todo_id = ?";
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = MySQLConnection.getInstance().getConnection();

                preparedStatement = connection.prepareStatement(findById);
                preparedStatement.setInt(1, todoId);

                resultSet = preparedStatement.executeQuery();

                if (todoItemFound.getTodoId() != todoItemFound.getAssignee().getPersonId()) {
                    new Todo(
                            resultSet.getInt("todo_id"),
                            resultSet.getString("title"),
                            resultSet.getString("description"),
                            resultSet.getDate(4).toLocalDate(),
                            resultSet.getBoolean("done"),
                            null
                    );

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return todoItemFound.getTodoId();

    }

    @Override
    public Todo update(Todo todo) {
       
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        Todo updatedTodo = null;

        try{
            connection = MySQLConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("UPDATE todo_items SET todo_id =?, title = ?, description = ?, deadline =?, done= ?, assignee_id = ?");
            preparedStatement.setInt(1, todo.getTodoId());
            preparedStatement.setString(2, todo.getTitle());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setObject(4, todo.getDeadline());
            preparedStatement.setBoolean(5, todo.isDone());
            preparedStatement.setInt(6, todo.getAssignee().getPersonId());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }


        if (rowsAffected >= 1){
            return todo;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteById(int todoId) {
        String deleteById = "DELETE FROM todo_item WHERE todo_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean wasDeleted = false;

        try {
            connection = MySQLConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(deleteById);
            preparedStatement.setInt(1, todoId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wasDeleted;

    }


}



