package com.example.onkarpande.mp_project.Entity;

public class ItemMenu {
    String price;
    String name;
    String id;
    String url;

    public ItemMenu()
    {

    }
    public ItemMenu(String id, String name, String price, String url) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.url =url;
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

}
