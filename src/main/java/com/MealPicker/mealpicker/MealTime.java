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
}
