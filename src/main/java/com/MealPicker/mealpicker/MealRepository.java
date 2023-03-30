package com.MealPicker.mealpicker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {


        @Query("SELECT m FROM Meal m " +
                "WHERE m.id IN (SELECT ms.meal.id FROM MealSeason ms WHERE ms.season.name = :seasonName) " +
                "AND m.id IN (SELECT mmt.meal.id FROM MealMealTime mmt WHERE mmt.mealTime.name = :mealTimeName) " +
                "ORDER BY RAND()")
        Meal findRandomMealBySeasonAndMealTime(@Param("seasonName") String seasonName,
                                               @Param("mealTimeName") String mealTimeName);

    }
