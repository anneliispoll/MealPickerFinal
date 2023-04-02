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
    @JoinColumn(name = "MealTimeID")
    private MealTime mealTime;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }
}
