package main.java.org.example;

import main.java.org.example.entities.Client;
import main.java.org.example.entities.Product;
import main.java.org.example.entities.Sale;

public class Main {
    public static void main(String[] args) {

        Product eraser = new Product(1, "Eraser", "Erase everything", 1.50, 50);
        Client myClient = new Client(1, "Peter", "peter@gmail.com", "random street, 24", null);
        Sale mySale = new Sale(1, myClient, null, "03/04/2024", 54.50);

        System.out.println(mySale);
        System.out.println(eraser);
        System.out.println(myClient);

    }
}