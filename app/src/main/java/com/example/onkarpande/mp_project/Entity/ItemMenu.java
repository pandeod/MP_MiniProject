package com.example.onkarpande.mp_project.Entity;

public class ItemMenu {
    String price;
    String name;
    String id;
    String url;
    int quantity;

    public ItemMenu()
    {

    }
    public ItemMenu(String id, String name, String price, String url) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.url =url;
        this.quantity=0;
    }

    public ItemMenu(String id, String name, String price, int quantity) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.quantity =quantity;
    }

    public String getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return url;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
