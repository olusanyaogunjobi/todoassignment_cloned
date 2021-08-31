package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.util.Collection;

public interface TodoItemsDao {

Todo create (Todo todo);
Collection<Todo> findAll();
Todo findById(int todoId);
boolean findByDoneStatus(boolean done);
Collection<Todo> findByAssignee(int personId);
Collection<Todo> findByAssignee(Person person);
int findByUnassignedTodoItems(int todoId);
Todo update(Todo todo);
boolean deleteById(int todoId);


}