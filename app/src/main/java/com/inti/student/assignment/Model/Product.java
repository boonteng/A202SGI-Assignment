package com.inti.student.assignment.Model;

/**
 * Created by HP on 30/11/2018.
 */

public class Product {

    private String Name, Image, Description, Price, Discount, MenuId;

    public Product() {

    }

    public Product(String name, String menuId, String image, String price, String description, String discount) {
        Name = name;
        MenuId = menuId;
        Image = image;
        Price = price;
        Description = description;
        Discount = discount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
