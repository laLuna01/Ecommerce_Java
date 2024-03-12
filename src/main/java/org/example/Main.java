package org.example;

import org.example.entities.Client;
import org.example.entities.Product;
import org.example.entities.Sale;
import org.example.entities.SaleItem;
import org.example.repositories._BaseRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        _BaseRepositoryImpl<Product> productRepository = new _BaseRepositoryImpl<>(Product.class);
        _BaseRepositoryImpl<Client> clientRepository = new _BaseRepositoryImpl<>(Client.class);
        _BaseRepositoryImpl<Sale> saleRepository = new _BaseRepositoryImpl<>(Sale.class);

        Product pencil = new Product(1, "Pencil", "6B", 0.5, 80);
        Product eraser = new Product(2, "Eraser", "Erases everything", 2.50, 50);

        Client myClient = new Client(1, "Peter", "peter@gmail.com", "random street, 24");
        Sale mySale = new Sale(1, myClient);

        SaleItem item1 = new SaleItem(pencil, 5);
        SaleItem item2 = new SaleItem(eraser, 2);

        myClient.addPurchase(mySale);

        mySale.addItem(item1);
        mySale.addItem(item2);

        System.out.println(mySale.calculateTotal());

        System.out.println(mySale);
        System.out.println(myClient);

        productRepository.Create(pencil);
        productRepository.Create(eraser);
        System.out.println(pencil);

        System.out.println(productRepository.Read());
        productRepository.toJson();

        productRepository.Delete(pencil);
        productRepository.Delete(eraser);
        System.out.println(productRepository.Read());

        productRepository.fromJson();
        System.out.println(productRepository.Read());

        pencil = pencil.fromJsonProduct(productRepository.fromJson());
        System.out.println(pencil.getName());
        System.out.println(pencil);
//        productRepository.Delete(pencil);
//        System.out.println(productRepository.Read());


    }
}