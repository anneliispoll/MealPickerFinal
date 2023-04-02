package com.MealPicker.mealpicker;

import java.io.Serializable;

public class MealMealTimeId implements Serializable {

    private Integer meal;
    private Integer mealTime;

    public MealMealTimeId() {}

    public MealMealTimeId(Integer meal, Integer mealTime) {
        this.meal = meal;
        this.mealTime = mealTime;
    }

}
