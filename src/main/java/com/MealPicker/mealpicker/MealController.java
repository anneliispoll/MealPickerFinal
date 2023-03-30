package com.MealPicker.mealpicker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mealpicker")
@CrossOrigin(origins = "http://localhost:3000")
public class MealController {


    @Autowired
    private MealPickerServices mealPickerServices;


    @GetMapping("/random")
    public ResponseEntity<String> getRandomMeal(@RequestParam("seasonName") String seasonName,
                                                @RequestParam("mealTimeName") String mealTimeName) {
        String meal = mealPickerServices.getRandomMealBySeasonAndMealTime(seasonName, mealTimeName);
        if (meal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meal);

        }
    }

