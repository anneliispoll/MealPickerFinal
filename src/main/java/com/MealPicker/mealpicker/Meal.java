package com.MealPicker.mealpicker;

import jakarta.persistence.*;

@Entity
@Table(name= "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MealID")
    private int id;

    @Column(name = "MealName")
    private String name;


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
}
