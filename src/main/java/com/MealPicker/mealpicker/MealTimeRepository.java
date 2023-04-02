package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealTimeRepository extends JpaRepository<Season, Integer> {
    MealTime findByName(String mealTimeName);
}
