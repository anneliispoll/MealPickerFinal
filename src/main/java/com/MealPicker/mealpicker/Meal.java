package com.MealPicker.mealpicker;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MealID")
    private int id;

    @Column(name = "meal_name")
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "meal_seasons",
            joinColumns = @JoinColumn(name = "MealID"),
            inverseJoinColumns = @JoinColumn(name = "SeasonID")
    )
    @OrderColumn(name = "season_order")
    private List<Season> seasons = new ArrayList<>();



    public Meal(String name) {
        this.name = name;
    }


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