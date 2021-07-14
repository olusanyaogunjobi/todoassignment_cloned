package se.lexicon.functions;

import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {

        List<Product> listOfProduct= Arrays.asList(
                new Product("bcar",150000,1),
                new Product("computer",10000,0),
                new Product("mobile",8000,10),
                new Product("usb",140,310)
        );


        number1(listOfProduct,(Product p)-> p.getStock()==0,(Product p)-> System.out.println(p));
        number1(listOfProduct,(Product p)-> p.getProductName().startsWith("b"),(Product p)-> System.out.println(p));
        number1(listOfProduct,(Product p)-> p.getPrise()>100 & p.getPrise()<150 ,(Product p)-> System.out.println(p));
        number1(listOfProduct,(Product p)-> p.getStock()>10 & p.getStock()<0 ,(Product p)-> p.setPrise(p.getPrise()*20/100));








    }
    public static void number1(List<Product> products,Conditional conditional,Action action){
        for(Product p: products){
            if(conditional.test(p)){
                action.execute(p);
            }
        }
    }





}
