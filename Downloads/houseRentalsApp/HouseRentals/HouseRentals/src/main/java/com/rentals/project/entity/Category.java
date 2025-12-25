package com.rentals.project.entity;

public class Category {
    private Long CategoryId;
    private String Categoryname;


    public Category(Long categoryId, String categoryname) {
        this.CategoryId = categoryId;
        this.Categoryname = categoryname;
    }

    public String getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.Categoryname = categoryname;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.CategoryId = categoryId;
    }

}
