package se.lexicon.collections;

import java.util.*;

public class collectionsExample {
    public static void main(String[] args) {

       // ex1();
       // ex2();
        //ex3();
        //ex4();
        //ex5();
        //ex6();
        //ex7();
        //ex8();
        //ex9();
        ex10();
        ex11();
       Car Benz=new Car(1,"Benz","123");
        Car volvo=new Car(2,"volvo","234");
       // System.out.println( System.out.println("brands:"+Benz.getValue());
//);


    }
      public static void ex1(){
        List<String> list=new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
//        list.add("Monday");
//        list.add("Tuesday");
//        list.add("Wednesday");
//        list.add("Thursday");
//        list.add("Friday");
//        list.add("Saturday");
//        list.add("Sunday");
          System.out.println("week days:"+list);
}
     public static void ex2(){
        List<String> list=new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));

        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String days=iterator.next();
            System.out.println("days:"+days);
        }

    }
    public static void ex3(){
        List<String> list=new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday", "Saturday", "Sunday"));
        list.add(3,"Thursday");
        System.out.println("list = " + list);


    }
    public static void ex4(){
        List<String> list=new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday", "Saturday", "Sunday"));
        List<String> sList=list.subList(0,3);
        System.out.println("sublist:"+sList);

    }
    public static void ex5(){
        HashSet<String> hash=new HashSet<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday", "Saturday", "Sunday"));
        System.out.println("days:"+hash);


    }
    public static void ex6(){
        HashSet<String> hash=new HashSet<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday", "Saturday", "Sunday"));
        List<String> list=new ArrayList<String>(hash);
        System.out.println("hash to arraylist:"+list);
    }
    public static void ex7(){
        HashSet<String> hash=new HashSet<>(Arrays.asList("Dena", "Anton", "Jona", "Tina", "Mina", "Sana"));
        List<String> names=new ArrayList<>(hash);
        names.set(0,"Anton");
        names.set(1,"Dena");
        names.set(2,"Jona");
        names.set(3,"Mina");
        names.set(4,"Sana");
        names.set(5,"Tina");
        System.out.println("names:"+names);
    }
    public static void ex8(){
        HashSet<String> hash=new HashSet<>(Arrays.asList("Dena", "Anton", "Jona", "Tina", "Mina", "Sana"));
       TreeSet<String> setHash=new TreeSet<String>(hash);
        System.out.println("sorted has:"+setHash);
        //collections.sort(hash);
    }
    public static void ex9(){
        HashMap<Integer,String> hMap=new HashMap<Integer,String>();
        hMap.put(1,"dena");
        hMap.put(2,"anton");
        hMap.put(3,"lale");
        System.out.println(hMap);
    }
    public static void ex10(){
        HashMap<Integer,String> hMap=new HashMap<Integer,String>();
        hMap.put(1,"Benz");
        hMap.put(2,"Toyota");
        hMap.put(3,"Volvo");
        for(Map.Entry m:hMap.entrySet())
        System.out.println("ID:"+m.getKey());
    }
    public static void ex11(){
        HashMap<Integer,String> hMap=new HashMap<Integer,String>();
        hMap.put(1,"Benz");
        hMap.put(2,"Toyota");
        hMap.put(3,"Volvo");
        for(Map.Entry m:hMap.entrySet())
            System.out.println("brands:"+m.getValue());
    }


}

