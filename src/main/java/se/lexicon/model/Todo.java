package se.lexicon.model;


public class Todo {

    private int todoId;
    public String description;
    public boolean done;
    Person assignee;

    //constructor


    public Todo(int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }


    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }
}
