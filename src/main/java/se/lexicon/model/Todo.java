package se.lexicon.model;


public class Todo {
    public static int idCounter=0;

    private int todoId;
    private String description;
    private boolean done;
    Person assignee;

    //constructor


    public Todo(String description,boolean done,Person assignee) {
        this.todoId = todoId;
        this.description = description;
        this.assignee=assignee;
        todoId=++idCounter;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public Person getAssignee() {
        return assignee;
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
