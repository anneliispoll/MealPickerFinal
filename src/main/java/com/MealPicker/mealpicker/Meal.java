package com.MealPicker.mealpicker;

import jakarta.persistence.*;

@Entity
@Table(name= "MealPicker")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MealID")
    private Integer MealID;

    @Column(name = "MealName")
    private String MealName;

    @Column(name = "breakfast")
    private boolean breakfast;

    @Column(name = "lunch")
    private boolean lunch;

    @Column(name = "dinner")
    private boolean dinner;

    @Column(name = "winter")
    private boolean winter;

    @Column(name = "spring")
    private boolean spring;

    @Column(name = "summer")
    private boolean summer;

    @Column(name = "autumn")
    private boolean autumn;



    public Integer getId() {
        return MealID;
    }

    public void setId(Integer id) {
        this.MealID = id;
    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String MealName) {
        this.MealName = MealName;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isLunch() {
        return lunch;
    }

    public void setLunch(boolean lunch) {
        this.lunch = lunch;
    }

    public boolean isDinner() {
        return dinner;
    }

    public void setDinner(boolean dinner) {
        this.dinner = dinner;
    }

    public boolean isSpring() {
        return spring;
    }

    public void setSpring(boolean spring) {
        this.spring = spring;
    }

    public boolean isSummer() {
        return summer;
    }

    public void setSummer(boolean summer) {
        this.summer = summer;
    }

    public boolean isAutumn() {
        return autumn;
    }

    public void setAutumn(boolean autumn) {
        this.autumn = autumn;
    }

    public boolean isWinter() {
        return winter;
    }

    public void setWinter(boolean winter) {
        this.winter = winter;
    }
}
