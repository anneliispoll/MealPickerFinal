package com.MealPicker.mealpicker;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meal_times")
public class MealTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_timeid")
    private int id;

    @Column(name = "meal_time_name")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "meal_meal_times",
            joinColumns = { @JoinColumn(name = "meal_timeid") },
            inverseJoinColumns = { @JoinColumn(name = "MealID") }
    )

    private List<Meal> meals = new ArrayList<>();

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
