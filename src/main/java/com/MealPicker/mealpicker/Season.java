package com.MealPicker.mealpicker;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeasonID")
    private int id;

    @Column(name= "season_name")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "meal_seasons",
            joinColumns = { @JoinColumn(name = "SeasonID") },
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
}
