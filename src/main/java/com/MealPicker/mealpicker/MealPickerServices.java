package com.MealPicker.mealpicker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealPickerServices {

    @Autowired
    private MealRepository mealRepository;

    public String getRandomMealBySeasonAndMealTime(String seasonName, String mealTimeName) {
        return mealRepository.findRandomMealBySeasonAndMealTime(seasonName, mealTimeName);
    }

    }