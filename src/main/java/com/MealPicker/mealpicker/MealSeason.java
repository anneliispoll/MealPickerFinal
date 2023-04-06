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


}
