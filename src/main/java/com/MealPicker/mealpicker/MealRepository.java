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
            "INNER JOIN meal_times mt ON mmt.meal_timeid = mt.meal_timeid " +
            "WHERE s.season_name = :seasonName AND mt.meal_time_name = :mealTimeName " +
            "ORDER BY RAND() " +
            "LIMIT 1")
    String findRandomMealBySeasonAndMealTime(@Param("seasonName") String seasonName, @Param("mealTimeName") String mealTimeName);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO meals (meal_name) VALUES (:name)")
    void addNewMeal(@Param("name") String name);


    @Query(nativeQuery = true, value = "SELECT m.MealID FROM meals m WHERE m.meal_name = :name")
    Integer findIdByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT s.SeasonID FROM seasons s WHERE s.season_name = :seasonNames")
    List<Integer> getSeasonIdsByNames(@Param("seasonNames") List<String> seasonNames);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO meal_seasons (MealID, SeasonID) " +
            "SELECT :mealId, :seasonIds")
    void addMealToSeasons(@Param("mealId") int mealId, @Param("seasonIds") List<Integer> seasonIds);

    @Query(nativeQuery = true, value = "SELECT mt.meal_timeid FROM meal_times mt WHERE mt.meal_time_name = :mealTimeNames")
    List<Integer> getMealTimeIdsByNames(@Param("mealTimeNames") List<String> mealTimeNames);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO meal_meal_times(MealID, meal_timeid) " +
            "SELECT :mealId, :mealTimeIds")
    void addMealToMealTimes(@Param("mealId") int mealId, @Param("mealTimeIds") List<Integer> mealTimeIds);



    Optional<Meal> findByName(String name);


}



