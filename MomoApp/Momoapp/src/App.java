import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import database.Database;
import entity.Product;
import module.ActionProducts;
import until.ShowMenu;

public class App {

       public static void main(String[] args) throws Exception {

       

        Scanner scanner = new Scanner(System.in);
        ActionProducts actionProducts = new ActionProducts();

        Map<Integer, Product> products = Database.products;
        products.put(1, new Product(1,"Coke", 10000, 2));
        products.put(2, new Product(2,"Pepsi", 10000, 10));
        products.put(3, new Product(3,"Soda", 20000, 1));

        Integer selectMenu = null;
        

        do {
            actionProducts.show(products);
            ShowMenu.showMenu();
            selectMenu = scanner.nextInt();
            switch (selectMenu) {
                case 1:
                    actionProducts.buyProduct();
                    break;
                case 2:
                    System.out.println("Exit ! Thank you for using the service <3");
                    break;
                default:
                    System.out.println("Invalid request !!!");
            }
        } while (selectMenu != 2);

    }
}
