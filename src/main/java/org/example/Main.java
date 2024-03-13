package org.example;

import org.example.entities.Client;
import org.example.entities.Product;
import org.example.entities.Sale;
import org.example.entities.SaleItem;
import org.example.repositories._BaseRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        _BaseRepositoryImpl<Product> productRepository = new _BaseRepositoryImpl<>(Product.class);
        _BaseRepositoryImpl<Client> clientRepository = new _BaseRepositoryImpl<>(Client.class);
        _BaseRepositoryImpl<Sale> saleRepository = new _BaseRepositoryImpl<>(Sale.class);
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to the E-commerce system\n");

        boolean repeat = true;
        while (repeat) {
            try {
                System.out.println("""
                    |===========================|
                    | Select one option number: |
                    |===========================|
                    | 1 - Product menu          |
                    | 2 - Client menu           |
                    | 3 - Sale menu             |
                    | 4 - Quit                  |
                    |===========================|
                    """);
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Product");
                        break;
                    case 2:
                        System.out.println("Client");
                        break;
                    case 3:
                        System.out.println("Sale");
                        break;
                    case 4:
                        System.out.println("Closing program...");
                        repeat = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please use just numbers");
                scanner.nextLine();
            }
        }

//        Product pencil = new Product(1, "Pencil", "6B", 0.5, 80);
//        Product eraser = new Product(2, "Eraser", "Erases everything", 2.50, 50);
//
//        Client myClient = new Client(1, "Peter", "peter@gmail.com", "random street, 24");
//        Sale mySale = new Sale(1, myClient);
//
//        SaleItem item1 = new SaleItem(pencil, 5);
//        SaleItem item2 = new SaleItem(eraser, 2);
//
//        myClient.addPurchase(mySale);
//
//        mySale.addItem(item1);
//        mySale.addItem(item2);
//
//        System.out.println(mySale.calculateTotal());
//
//        System.out.println(mySale);
//        System.out.println(myClient);
//
//        saleRepository.Create(mySale);
//
//        productRepository.Create(pencil);
//        productRepository.Create(eraser);
//        System.out.println(pencil);
//
//        System.out.println(productRepository.Read());
//        productRepository.toJson();
//
//        productRepository.Delete(pencil);
//        productRepository.Delete(eraser);
//        System.out.println(productRepository.Read());
//
//        productRepository.fromJson();
//
//        System.out.println(productRepository.Read());
//    }
    }
}