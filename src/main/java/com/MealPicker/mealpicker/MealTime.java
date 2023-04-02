package com.MealPicker.mealpicker;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meal_times")
public class MealTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MealTimeID")
    private int id;

    @Column(name = "meal_time_name")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "meal_meal_times",
            joinColumns = { @JoinColumn(name = "MealTimeID") },
            inverseJoinColumns = { @JoinColumn(name = "MealID") }
    )
    private Set<Meal> meals = new HashSet<>();

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

    public Set<Meal> getMeals() {
        return meals;
    }

    public void addMeal(Meal one) {
    }
}
