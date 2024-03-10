package org.example.entities;

public class SaleItem {
    private Product product;
    private int quantity;

    public SaleItem() {
    }

    public SaleItem(Product product, int quantity) {
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
        return "SaleItem{" +
                "product: " + product +
                ", quantity: " + quantity +
                '}';
    }
}
