package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository <Season, Integer> {

    Season findByName(String seasonName);
}
