package com.MealPicker.mealpicker;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MealID")
    private int id;

    @Column(name = "meal_name")
    private String name;

    @ManyToMany(mappedBy = "meals")
    private Set<Season> seasons = new HashSet<>();

    @ManyToMany(mappedBy = "meals")
    private Set<MealTime> mealTimes = new HashSet<>();


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

    public void addSeason(Season season) {
    }

    public void addMealTime(MealTime mealTime) {
    }
}