package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository <Season, Integer> {

    Optional<Season> findByName(String seasonName);

    Optional<Season> findById(int seasonId);

}
