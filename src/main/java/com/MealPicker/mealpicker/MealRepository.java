package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {


    @Query(nativeQuery = true, value = "SELECT m.meal_name " +
            "FROM meals m " +
            "INNER JOIN meal_seasons ms ON m.MealID = ms.MealID " +
            "INNER JOIN seasons s ON ms.SeasonID = s.SeasonID " +
            "INNER JOIN meal_meal_times mmt ON m.MealID = mmt.MealID " +
            "INNER JOIN meal_times mt ON mmt.MealTimeID = mt.MealTimeID " +
            "WHERE s.SeasonName = :seasonName AND mt.MealTimeName = :mealTimeName " +
            "ORDER BY RAND() " +
            "LIMIT 1")
    String findRandomMealBySeasonAndMealTime(@Param("seasonName") String seasonName, @Param("mealTimeName") String mealTimeName);

    }
