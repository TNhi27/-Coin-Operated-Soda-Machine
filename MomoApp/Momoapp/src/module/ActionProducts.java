package module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import database.Database;
import entity.Product;
import until.CheckMoney;

public class ActionProducts {
    Scanner scanner = new Scanner(System.in);
    Promotion promotion = new Promotion();

    /**
     * Hiển thị danh sách sản phẩm ra màng hình
     * 
     * @param list đối tượng Map các sản phẩm để hiện thị
     */
    public void show(Map<Integer, Product> list) {
        System.out.println("List Product");

        System.out.println("Key \t Name \t Price \t Qty");
        Set<Integer> set = list.keySet();
        for (Integer key : set) {
            Product p = list.get(key);
            System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getQty());
        }
    }

    /**
     * Thực hiện thao tác mua sản phẩm
     */
    public void buyProduct() {

        System.out.println("Enter id product");
        Integer choose = scanner.nextInt();
        System.out.println("Enter qty product");
        Integer qty = scanner.nextInt();
        System.out.println("Enter money");
        Integer money = scanner.nextInt();

        Map<Integer, Product> products = Database.products;

        Integer acp =null;
        System.out.println("Continue ? 1 is YES/ 0 is NO : ");
        acp = scanner.nextInt();

        if (acp==1) {
            if (CheckMoney.check(money)) {
                Product p = products.get(choose);

                Integer total = p.getPrice() * qty;

                Integer returnMoney = money - total;
                if (returnMoney < 0) {
                    System.out.println("You don't have enough money :(");
                } else {
                    Integer currentQty = p.getQty();
                    if (qty > currentQty) {
                        System.out.println("Product is out of stock ");
                        System.out.println("Return money : " + money);
                    } else {
                        p.setQty(p.getQty() - qty);

                        System.out.println("*----------*");
                        System.out.println("* Success ! *");
                        System.out.println("*----------*");
                        System.out.println("Return money :" + returnMoney);
                        Database.id = choose;
                        if (choose == Database.id) {
                            Database.count++;
                            if (Database.count == 3) {
                                promotion.doPromotion(Database.products.get(choose));
                            }
                        } else {
                            Database.count = 0;
                        }

                    }

                }

            } else {
                System.out.println("Money Not valid !!!");
            }
        } else {
            System.out.println("Return money : " + money);
        }

    }

}