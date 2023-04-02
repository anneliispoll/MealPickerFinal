package com.MealPicker.mealpicker;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {


    @Query(nativeQuery = true, value = "SELECT m.meal_name " +
            "FROM meals m " +
            "INNER JOIN meal_seasons ms ON m.MealID = ms.MealID " +
            "INNER JOIN seasons s ON ms.SeasonID = s.SeasonID " +
            "INNER JOIN meal_meal_times mmt ON m.MealID = mmt.MealID " +
            "INNER JOIN meal_times mt ON mmt.MealTimeID = mt.MealTimeID " +
            "WHERE s.season_name = :seasonName AND mt.meal_time_name = :mealTimeName " +
            "ORDER BY RAND() " +
            "LIMIT 1")
    String findRandomMealBySeasonAndMealTime(@Param("seasonName") String seasonName, @Param("mealTimeName") String mealTimeName);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO meals (meal_name) VALUES (:name)")
    void addNewMeal(@Param("name") String name);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO meal_seasons (MealID, SeasonID) " +
            "SELECT m.MealID, s.SeasonID " +
            "FROM meals m " +
            "CROSS JOIN seasons s " +
            "WHERE s.season_name IN :seasonName AND m.meal_name = :name")
    void addMealToSeasons(@Param("name") String name, @Param("seasonName") List<String> seasonName);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO meal_meal_times(MealID, MealTimeID) " +
            "SELECT :mealId, mt.MealTimeID " +
            "FROM meal_times mt " +
            "WHERE mt.meal_time_name IN :mealTimeName")
    void addMealToMealTimes(@Param("mealId") int mealId, @Param("mealTimeName") List<String> mealTimeName);



    Optional<Meal> findByName(String name);


}



