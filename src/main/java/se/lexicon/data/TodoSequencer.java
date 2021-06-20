package se.lexicon.data;

public class TodoSequencer {
    private static int toDoId=0;

    public static int nextTodoId(){
        return ++toDoId;
    }
    public static void reset(){
        toDoId=0;
    }



}
