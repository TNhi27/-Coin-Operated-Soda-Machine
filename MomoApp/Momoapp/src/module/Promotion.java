package module;

import java.util.Random;

import database.Database;
import entity.Product;

public class Promotion {

    public static final float CHANCE = 10/100;
    public static final int LIMIT_BUDGET=50000;


    Random ran  = new Random();
    public void doPromotion(Product product) {
        if (Database.budget<=50000) {
            boolean check = ran.nextDouble()<CHANCE;
            if (check) {
                System.out.println("Congratulations, you have received 1 free product : "+product.getName());
                Database.budget+=product.getPrice();
            }else{
                System.out.println("Thank you for participating in the program, good luck next time :(");
            }
        }else{
            System.out.println("Exceeding the allowable budget "+LIMIT_BUDGET+"/NGAY");
        }
    }
}