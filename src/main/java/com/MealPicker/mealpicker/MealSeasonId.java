package com.MealPicker.mealpicker;

import java.io.Serializable;

public class MealSeasonId implements Serializable {
    private Meal meal;

    private Season season;

    // Add getters and setters for the new field
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
