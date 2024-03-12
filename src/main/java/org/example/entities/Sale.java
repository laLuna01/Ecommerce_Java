package org.example.entities;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sale extends _BaseEntity {
    private  Client client;
    private List<SaleItem> saleItems = new ArrayList<>();
    private LocalDate date = LocalDate.now();
    private double total;

    public Sale() {

    }

    public Sale(int id, Client client) {
        super(id);
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addItem(SaleItem item) {
        saleItems.add(item);
    }
    public double calculateTotal() {
        for (int i = 0; i < saleItems.size(); i++) {
            total += saleItems.get(i).getProduct().getPrice() * saleItems.get(i).getQuantity();
        }
        return total;
    }

    public Sale fromJsonSale(String json) {
        try {
            Sale sale = new Gson().fromJson(json, Sale.class);
            return sale;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id: " + getId() +
                ", client: " + client.getName() +
                ", sale items: " + saleItems +
                ", date: " + date +
                ", total: " + total +
                '}';
    }
}
