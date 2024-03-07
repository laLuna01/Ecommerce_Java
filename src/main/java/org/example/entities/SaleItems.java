package main.java.org.example.entities;

import java.util.List;

public class SaleItems {
    private Product product;
    private int quantity;

    public SaleItems() {

    }

    public SaleItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleItems{" +
                "product: " + product +
                ", quantity: " + quantity +
                '}';
    }
}
