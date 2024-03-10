package org.example.entities;

public class Product extends _BaseEntity {
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product() {

    }

    public Product(int id, String name, String description, double price, int stock) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id: " + getId() +
                ", name: " + name +
                ", description: " + description +
                ", price: " + price +
                ", stock: " + stock +
                '}';
    }
}
