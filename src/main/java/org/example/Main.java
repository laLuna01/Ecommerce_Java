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

        boolean repeatMain = true;
        while (repeatMain) {
            try {
                System.out.println("""
                    |===========================|
                    | Main menu:                |
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
                        boolean repeatProduct = true;
                        while (repeatProduct) {
                            try {
                                System.out.println("""
                                    |===========================|
                                    | Product menu:             |
                                    |===========================|
                                    | 1 - Create product        |
                                    | 2 - Read products         |
                                    | 3 - Update product        |
                                    | 4 - Delete product        |
                                    | 5 - Export products       |
                                    | 6 - Import product        |
                                    | 7 - Return                |
                                    |===========================|
                                    """);
                                option = scanner.nextInt();
                                scanner.nextLine();
                                switch (option) {
                                    case 1:
                                        System.out.println("\n--- New Product: ---\n");
                                        Product newProduct = new Product();
                                        System.out.println("Product ID: ");
                                        newProduct.setId(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Product name: ");
                                        newProduct.setName(scanner.nextLine());
                                        System.out.println("Product description: ");
                                        newProduct.setDescription(scanner.nextLine());
                                        System.out.println("Product price: ");
                                        double price = Double.parseDouble(scanner.next());
                                        newProduct.setPrice(price);
                                        System.out.println("Product stock: ");
                                        newProduct.setStock(scanner.nextInt());
                                        productRepository.Create(newProduct);
                                        break;
                                    case 2:
                                        System.out.println("\n--- All Products: ---\n");
                                        System.out.println(productRepository.Read() + "\n");
                                        break;
                                    case 3:
                                        System.out.println("\n--- Update Product: ---\n");
                                        Product product = new Product();
                                        System.out.println("Product ID: ");
                                        product.setId(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Product name: ");
                                        product.setName(scanner.nextLine());
                                        System.out.println("Product description: ");
                                        product.setDescription(scanner.nextLine());
                                        System.out.println("Product price: ");
                                        price = Double.parseDouble(scanner.next());
                                        product.setPrice(price);
                                        System.out.println("Product stock: ");
                                        product.setStock(scanner.nextInt());
                                        productRepository.Update(product);
                                        break;
                                    case 4:
                                        System.out.println("\n--- Delete product: ---\n");
                                        System.out.println("Product ID: ");
                                        productRepository.Delete(scanner.nextInt());
                                        break;
                                    case 5:
                                        System.out.println("Exporting products...");
                                        productRepository.toJson();
                                        System.out.println("Success!");
                                        break;
                                    case 6:
                                        System.out.println("Importing products...");
                                        System.out.println(productRepository.fromJson());
                                        productRepository.Read();
                                        break;
                                    case 7:
                                        repeatProduct = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } catch (java.util.InputMismatchException e) {
                                System.out.println(e.getMessage());
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 2:
                        boolean repeatClient = true;
                        while (repeatClient) {
                            try {
                                System.out.println("""
                                    |===========================|
                                    | Client menu:              |
                                    |===========================|
                                    | 1 - Create client         |
                                    | 2 - Read clients          |
                                    | 3 - Update client         |
                                    | 4 - Delete client         |
                                    | 5 - Export clients        |
                                    | 6 - Import clients        |
                                    | 7 - Return                |
                                    |===========================|
                                    """);
                                option = scanner.nextInt();
                                scanner.nextLine();
                                switch (option) {
                                    case 1:
                                        System.out.println("\n--- New Client: ---\n");
                                        Client newClient = new Client();
                                        System.out.println("Client ID: ");
                                        newClient.setId(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Client name: ");
                                        newClient.setName(scanner.nextLine());
                                        System.out.println("Client e-mail: ");
                                        newClient.setEmail(scanner.nextLine());
                                        System.out.println("Client address: ");
                                        newClient.setAddress(scanner.nextLine());
                                        clientRepository.Create(newClient);
                                        break;
                                    case 2:
                                        System.out.println("\n--- All Clients: ---\n");
                                        System.out.println(clientRepository.Read() + "\n");
                                        break;
                                    case 3:
                                        System.out.println("\n--- Update Client: ---\n");
                                        Client client = new Client();
                                        System.out.println("Client ID: ");
                                        client.setId(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Client name: ");
                                        client.setName(scanner.nextLine());
                                        System.out.println("Client e-mail: ");
                                        client.setEmail(scanner.nextLine());
                                        System.out.println("Client address: ");
                                        client.setAddress(scanner.nextLine());
                                        clientRepository.Update(client);
                                        break;
                                    case 4:
                                        System.out.println("\n--- Delete Client: ---\n");
                                        System.out.println("Client ID: ");
                                        clientRepository.Delete(scanner.nextInt());
                                        break;
                                    case 5:
                                        System.out.println("Exporting clients...");
                                        clientRepository.toJson();
                                        System.out.println("Success!");
                                        break;
                                    case 6:
                                        System.out.println("Importing clients...");
                                        System.out.println(clientRepository.fromJson());
                                        clientRepository.Read();
                                        break;
                                    case 7:
                                        repeatClient = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } catch (java.util.InputMismatchException e) {
                                System.out.println(e.getMessage());
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 3:
                        boolean repeatSale = true;
                        while (repeatSale) {
                            try {
                                System.out.println("""
                                    |===========================|
                                    | Sale menu:                |
                                    |===========================|
                                    | 1 - Create sale           |
                                    | 2 - Read sales            |
                                    | 3 - Update sale           |
                                    | 4 - Delete sale           |
                                    | 5 - Export sales          |
                                    | 6 - Import sales          |
                                    | 7 - Return                |
                                    |===========================|
                                    """);
                                option = scanner.nextInt();
                                scanner.nextLine();
                                switch (option) {
                                    case 1:
                                        System.out.println("\n--- New Sale: ---\n");
                                        Sale newSale = new Sale();
                                        System.out.println("Sale ID: ");
                                        newSale.setId(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Client id: ");
                                        newSale.setClient(clientRepository.addClientToSale(scanner.nextInt()));
                                        scanner.nextLine();
                                        boolean repeatAddItem = true;
                                        while (repeatAddItem) {
                                            SaleItem saleItem = new SaleItem();
                                            System.out.println("--- Add Sale Item ---");
                                            System.out.println("Product ID: ");
                                            saleItem.setProduct(productRepository.addProductToSaleItem(scanner.nextInt()));
                                            System.out.println("Quantity: ");
                                            saleItem.setQuantity(scanner.nextInt());
                                            newSale.addItem(saleItem);
                                            System.out.println("\nItem added\n");
                                            try {
                                                System.out.println("""
                                                    1 - Add one more item
                                                    2 - Finish and calculate total
                                                    """);
                                                int addMore = scanner.nextInt();
                                                switch (addMore) {
                                                    case 1:
                                                        break;
                                                    case 2:
                                                        repeatAddItem = false;
                                                        break;
                                                }
                                            }   catch (java.util.InputMismatchException e) {
                                                System.out.println("Please use a valid input");
                                                scanner.nextLine();
                                            }
                                        }
                                        newSale.calculateTotal();
                                        System.out.println("Total: " + newSale.getTotal());
                                        saleRepository.Create(newSale);
                                        break;
                                    case 2:
                                        System.out.println("\n--- All Sales: ---\n");
                                        System.out.println(saleRepository.Read() + "\n");
                                        break;
                                    case 3:
                                        System.out.println("\n--- Update Sale: ---\n");
                                        Sale sale = new Sale();
                                        System.out.println("Sale ID: ");
                                        sale.setId(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Client id: ");
                                        sale.setClient(clientRepository.addClientToSale(scanner.nextInt()));
                                        scanner.nextLine();
                                        repeatAddItem = true;
                                        while (repeatAddItem) {
                                            SaleItem saleItem = new SaleItem();
                                            System.out.println("--- Add Sale Item ---");
                                            System.out.println("Product ID: ");
                                            saleItem.setProduct(productRepository.addProductToSaleItem(scanner.nextInt()));
                                            System.out.println("Quantity: ");
                                            saleItem.setQuantity(scanner.nextInt());
                                            sale.addItem(saleItem);
                                            System.out.println("\nItem added\n");
                                            try {
                                                System.out.println("""
                                                    1 - Add one more item
                                                    2 - Finish and calculate total
                                                    """);
                                                int addMore = scanner.nextInt();
                                                switch (addMore) {
                                                    case 1:
                                                        break;
                                                    case 2:
                                                        repeatAddItem = false;
                                                        break;
                                                }
                                            }   catch (java.util.InputMismatchException e) {
                                                System.out.println("Please use a valid input");
                                                scanner.nextLine();
                                            }
                                        }
                                        sale.calculateTotal();
                                        System.out.println("Total: " + sale.getTotal());
                                        saleRepository.Update(sale);
                                        break;
                                    case 4:
                                        System.out.println("\n--- Delete Sale: ---\n");
                                        System.out.println("Sale ID: ");
                                        saleRepository.Delete(scanner.nextInt());
                                        break;
                                    case 5:
                                        System.out.println("Exporting sales...");
                                        saleRepository.toJson();
                                        System.out.println("Success!");
                                        break;
                                    case 6:
                                        System.out.println("Importing sales...");
                                        System.out.println(saleRepository.fromJson());
                                        saleRepository.Read();
                                        break;
                                    case 7:
                                        repeatSale = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Please use a valid input");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Closing program...");
                        repeatMain = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please use a valid input");
                scanner.nextLine();
            }
        }

    }
}