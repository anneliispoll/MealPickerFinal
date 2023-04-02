package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealMealTimeRepository extends JpaRepository<MealMealTime, Integer> {
}
