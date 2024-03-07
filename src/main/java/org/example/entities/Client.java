package main.java.org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends _BaseEntity {
    private String name;
    private String email;
    private String address;
    private List<Sale> purchaseHistory = new ArrayList<>();

    public Client() {

    }

    public Client(int id, String name, String email, String address, List<Sale> buyHistory) {
        super(id);
        this.name = name;
        this.email = email;
        this.address = address;
        this.purchaseHistory = buyHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Sale> purchaseHistory() {
        return purchaseHistory;
    }

    public void setBuyHistory(List<Sale> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id: " + getId() +
                ", name: " + name +
                ", email: " + email +
                ", address: " + address +
                ", purchase history: " + purchaseHistory +
                '}';
    }
}
