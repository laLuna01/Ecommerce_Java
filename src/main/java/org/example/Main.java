package main.java.org.example;

import main.java.org.example.entities.Client;
import main.java.org.example.entities.Product;
import main.java.org.example.entities.Sale;
import main.java.org.example.entities.SaleItem;

public class Main {
    public static void main(String[] args) {

        Product pencil = new Product(1, "Pencil", "6B", 0.5, 80);
        Product eraser = new Product(2, "Eraser", "Erase everything", 1.50, 50);
        Client myClient = new Client(1, "Peter", "peter@gmail.com", "random street, 24");
        Sale mySale = new Sale(1, myClient, "03/04/2024");

        SaleItem item1 = new SaleItem(pencil, 5);
        SaleItem item2 = new SaleItem(eraser, 2);

        myClient.addPurchase(mySale);

        mySale.addItem(item1);
        mySale.addItem(item2);

        System.out.println(mySale.calculateTotal());

        System.out.println(mySale);
        System.out.println(eraser);
        System.out.println(myClient);

    }
}