package se.lexicon;

import se.lexicon.data.People;
import se.lexicon.data.PeopleDao;
import se.lexicon.data.TodoItems;
import se.lexicon.data.TodoItemsDao;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.sql.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {


    public static void main(String[] args) {

        TodoItemsDao todoItemsDao = new TodoItems();
        PeopleDao peopleDao = new People();

        Person person = new Person(0,"Sanya", "Ogunjobi");

        System.out.println("person = " + person);



    }

}



