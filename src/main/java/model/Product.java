package model;

public class Product {
    int id;
    String name;
    double price;
    int quantity;
    String color;
    String detail;
    String category;

    public Product() {
    }

    public Product(int id, String name, double price, int quantity, String color, String detail, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.detail = detail;
        this.category = category;
    }

    public Product(String name, double parseDouble, int parseInt, String color, String detail, String category) {
        this.name = name;
        this.price = getPrice();
        this.quantity = getQuantity();
        this.color = color;
        this.detail = detail;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
