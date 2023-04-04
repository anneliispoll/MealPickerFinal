package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealTimeRepository extends JpaRepository<MealTime, Integer> {
    Optional<MealTime> findByName(String mealTimeName);

    Optional<MealTime> findById(int id);
}
