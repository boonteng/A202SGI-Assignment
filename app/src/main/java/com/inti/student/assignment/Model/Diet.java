package com.inti.student.assignment.Model;

public class Diet { private String Name,MenuId, Image, Protein, Calcium, Carbohydrate,Fat,Water,Vitamin,Calories;

    public Diet() {

    }

    public Diet(String name, String menuId, String image, String protein, String calcium,
                String carbohydrate, String fat, String water, String vitamin, String calories) {
        Name = name;
        MenuId = menuId;
        Image = image;
        Protein = protein;
        Calcium = calcium;
        Carbohydrate = carbohydrate;
        Fat = fat;
        Water = water;
        Vitamin = vitamin;
        Calories = calories;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getProtein() {
        return Protein;
    }

    public void setProtein(String protein) {
        Protein = protein;
    }

    public String getCalcium() {
        return Calcium;
    }

    public void setCalcium(String calcium) {
        Calcium = calcium;
    }

    public String getCarbohydrate() {
        return Carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        Carbohydrate = carbohydrate;
    }

    public String getFat() {
        return Fat;
    }

    public void setFat(String fat) {
        Fat = fat;
    }

    public String getWater() {
        return Water;
    }

    public void setWater(String water) {
        Water = water;
    }

    public String getVitamin() {
        return Vitamin;
    }

    public void setVitamin(String vitamin) {
        Vitamin = vitamin;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }
}
