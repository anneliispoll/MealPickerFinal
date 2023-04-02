package com.MealPicker.mealpicker;

import jakarta.persistence.*;

@Entity
@IdClass(MealSeasonId.class)
@Table(name = "meal_seasons")
public class MealSeason {

    @Id
    @ManyToOne
    @JoinColumn(name = "MealID")
    private Meal meal;

    @Id
    @ManyToOne
    @JoinColumn(name = "SeasonID", insertable = false, updatable = false)
    private Season season;


    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
