package com.MealPicker.mealpicker;

import jakarta.persistence.*;

@Entity
@IdClass(MealMealTimeId.class)
@Table(name = "meal_meal_times")
public class MealMealTime {
    @Id
    @ManyToOne
    @JoinColumn(name = "MealID")
    private Meal meal;

    @Id
    @ManyToOne
    @JoinColumn(name = "meal_timeid")
    private MealTime mealTime;

}
