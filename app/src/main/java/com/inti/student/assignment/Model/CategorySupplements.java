package com.inti.student.assignment.Model;

/**
 * Created by HP on 30/11/2018.
 */

public class CategorySupplements {

    private String Name;
    private String Image;

    public CategorySupplements() {
    }

    public CategorySupplements(String name, String image) {
        Name = name;
        Image = image;
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
}
