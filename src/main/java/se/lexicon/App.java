package se.lexicon;

import se.lexicon.data.TodoItems;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person p=new Person("Dena","Aghajari");
        System.out.println("person ID is:"+Person.counter);
        System.out.println(p);

        Person newPerson=new Person("Anton","Lundin","dena.ag@gmail.com");
        System.out.println("person ID is:"+Person.counter);
        System.out.println(newPerson);

        Todo newToDo=new Todo( "Java lecture", true,newPerson );
        System.out.println("toDo ID is:"+Todo.idCounter);



    }

}



