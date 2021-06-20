package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.util.Arrays;

public class TodoItems {

    private static Todo[] whatTodo= new Todo[0];


public int getSize(){
    return whatTodo.length;

}
    public Todo[] findAll(String[] items){
        Todo[] Todo2= Arrays.copyOf(TodoItems.whatTodo, TodoItems.whatTodo.length);
        System.out.println(Arrays.toString(Todo2));
        return Todo2;
    }

    public Todo findById(int TodoId){

        for(Todo todoItems:whatTodo){
            if(todoItems.getTodoId()== TodoId){
                return todoItems;
            }
        }

        return null;
    }
    public void clear(){
        Arrays.fill(whatTodo, null);
        System.out.println(Arrays.toString(whatTodo));
    }

}


