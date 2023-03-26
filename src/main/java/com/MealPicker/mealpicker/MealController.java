package com.MealPicker.mealpicker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/mealpicker")
@CrossOrigin(origins = "http://localhost:3000")
public class MealController {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MealPickerServices mealPickerServices;


    @GetMapping("/random")
    public String getRandomMeal(@RequestParam boolean breakfast, @RequestParam boolean lunch, @RequestParam boolean dinner,
                                @RequestParam boolean spring, @RequestParam boolean summer, @RequestParam boolean autumn, @RequestParam boolean winter) {
        System.out.println("OUTPUT " + breakfast);
        List<String> mealNames = new ArrayList<>();

        if (breakfast && winter) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForBreakfastAndWinter(1));
        }
        if (lunch && winter) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForLunchAndWinter(1));
        }
        if (dinner && winter) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForDinnerAndWinter(1));
        }
        if (breakfast && spring) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForBreakfastAndSpring(1));
        }
        if (lunch && spring) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForLunchAndSpring(1));
        }
        if (dinner && spring) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForDinnerAndSpring(1));
        }
        if (breakfast && summer) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForBreakfastAndSummer(1));
        }
        if (lunch && summer) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForLunchAndSummer(1));
        }
        if (dinner && summer) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForDinnerAndSummer(1));
        }
        if (breakfast && autumn) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForBreakfastAndAutumn(1));
        }
        if (lunch && autumn) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForLunchAndAutumn(1));
        }
        if (dinner && autumn) {
            mealNames.addAll(mealPickerServices.getRandomMealNamesForDinnerAndAutumn(1));
        }

        if (mealNames.isEmpty()) {
            // no meals found matching the criteria, return an empty string
            return "";
        } else {
            // choose a random meal name from the list
            Random rand = new Random();
            String randomMealName = mealNames.get(rand.nextInt(mealNames.size()));
            return randomMealName;
        }
    }
}
