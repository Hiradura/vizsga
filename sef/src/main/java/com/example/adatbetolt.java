package com.example;

import java.time.LocalDate;

public class adatbetolt {
    private Integer id;
    private String chefname;
    private LocalDate date;
    private String category;
    private Integer price;
    private String comment;

    public adatbetolt() {}

    public adatbetolt(Integer id, String chefname, LocalDate date, String category, Integer price, String comment) {
        this.id = id;
        this.chefname = chefname;
        this.date = date;
        this.category = category;
        this.price = price;
        this.comment = comment;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getChefname() { return chefname; }
    public void setChefname(String chefname) { this.chefname = chefname; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
