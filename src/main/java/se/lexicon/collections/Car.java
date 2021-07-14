package se.lexicon.collections;

import java.util.HashMap;
import java.util.Map;

public class Car {
   int id;
   String brand;
   String model;


    public Car(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public static void hash(){
        HashMap<Integer,String> hMap=new HashMap<Integer,String>();
        hMap.put(1,"Benz");
        hMap.put(2,"Toyota");
        hMap.put(3,"Volvo");
        for(Map.Entry m:hMap.entrySet())
            System.out.println("brands:"+m.getValue());

    }
}
