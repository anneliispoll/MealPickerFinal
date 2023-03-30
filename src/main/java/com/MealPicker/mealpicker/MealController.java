package com.MealPicker.mealpicker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/mealpicker")
@CrossOrigin(origins = "http://localhost:3000")
public class MealController {


    @Autowired
    private MealPickerServices mealPickerServices;


    @GetMapping("/random")
    public ResponseEntity<Meal> getRandomMeal(@RequestParam("season") String seasonName,
                                              @RequestParam("mealTime") String mealTimeName) {
        Meal meal = mealPickerServices.getRandomMealBySeasonAndMealTime(seasonName, mealTimeName);
        if (meal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meal);

        }
    }

