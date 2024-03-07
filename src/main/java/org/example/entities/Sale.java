package main.java.org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class Sale extends _BaseEntity {
    private  Client client;
    private List<SaleItems> saleItems = new ArrayList<>();
    private String date;
    private double total;

    public Sale() {

    }

    public Sale(int id, Client client, List<SaleItems> saleItems, String date, double total) {
        super(id);
        this.client = client;
        this.saleItems = saleItems;
        this.date = date;
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<SaleItems> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItems> saleItems) {
        this.saleItems = saleItems;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id: " + getId() +
                ", client: " + client +
                ", sale items: " + saleItems +
                ", date: " + date +
                ", total: " + total +
                '}';
    }
}
