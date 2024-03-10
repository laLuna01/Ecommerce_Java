package org.example;

import org.example.entities.Client;
import org.example.entities.Product;
import org.example.entities.Sale;
import org.example.entities.SaleItem;
import org.example.repositories._BaseRepositoryImpl;

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

        _BaseRepositoryImpl<Product> productRepository = new _BaseRepositoryImpl<>();

        productRepository.Create(pencil);
        productRepository.Create(eraser);
        System.out.println(productRepository.Read());
        productRepository.Delete(eraser);
        System.out.println(productRepository.Read());

    }
}