package com.MealPicker.mealpicker;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {


        List<String> findRandomMealNameByBreakfastAndWinter(boolean breakfast, boolean winter, Pageable pageable);

        List<String> findRandomMealNameByLunchAndWinter(boolean lunch, boolean winter, Pageable pageable);

        List<String> findRandomMealNameByDinnerAndWinter(boolean dinner, boolean winter, Pageable pageable);

        List<String> findRandomMealNameByBreakfastAndSpring(boolean breakfast, boolean spring, Pageable pageable);

        List<String> findRandomMealNameByLunchAndSpring(boolean lunch, boolean spring, Pageable pageable);

        List<String> findRandomMealNameByDinnerAndSpring(boolean dinner, boolean spring, Pageable pageable);

        List<String> findRandomMealNameByBreakfastAndSummer(boolean breakfast, boolean summer, Pageable pageable);

        List<String> findRandomMealNameByLunchAndSummer(boolean lunch, boolean summer, Pageable pageable);

        List<String> findRandomMealNameByDinnerAndSummer(boolean dinner, boolean summer, Pageable pageable);

        List<String> findRandomMealNameByBreakfastAndAutumn(boolean breakfast, boolean autumn, Pageable pageable);

        List<String> findRandomMealNameByLunchAndAutumn(boolean lunch, boolean autumn, Pageable pageable);

        List<String> findRandomMealNameByDinnerAndAutumn(boolean dinner, boolean autumn, Pageable pageable);

    }
