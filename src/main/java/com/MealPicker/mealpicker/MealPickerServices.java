package com.MealPicker.mealpicker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealPickerServices {

    @Autowired
    private MealRepository mealRepository;

    public List<String> getRandomMealNamesForBreakfastAndWinter(int pageSize) {
        return mealRepository.findRandomMealNameByBreakfastAndWinter(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForLunchAndWinter(int pageSize) {
        return mealRepository.findRandomMealNameByLunchAndWinter(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForDinnerAndWinter(int pageSize) {
        return mealRepository.findRandomMealNameByDinnerAndWinter(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForBreakfastAndSpring(int pageSize) {
        return mealRepository.findRandomMealNameByBreakfastAndSpring(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForLunchAndSpring(int pageSize) {
        return mealRepository.findRandomMealNameByLunchAndSpring(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForDinnerAndSpring(int pageSize) {
        return mealRepository.findRandomMealNameByDinnerAndSpring(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForBreakfastAndSummer(int pageSize) {
        return mealRepository.findRandomMealNameByBreakfastAndSummer(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForLunchAndSummer(int pageSize) {
        return mealRepository.findRandomMealNameByLunchAndSummer(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForDinnerAndSummer(int pageSize) {
        return mealRepository.findRandomMealNameByDinnerAndSummer(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForBreakfastAndAutumn(int pageSize) {
        return mealRepository.findRandomMealNameByBreakfastAndAutumn(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForLunchAndAutumn(int pageSize) {
        return mealRepository.findRandomMealNameByLunchAndAutumn(true, true, PageRequest.of(0, pageSize));
    }

    public List<String> getRandomMealNamesForDinnerAndAutumn(int pageSize) {
        return mealRepository.findRandomMealNameByDinnerAndAutumn(true, true, PageRequest.of(0, pageSize));
    }
}