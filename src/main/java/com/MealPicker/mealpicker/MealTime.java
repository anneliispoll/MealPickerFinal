package com.MealPicker.mealpicker;

import jakarta.persistence.*;

@Entity
@Table(name = "meal_times")
public class MealTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MealTimeID")
    private int id;

    @Column(name = "MealTimeName")
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
