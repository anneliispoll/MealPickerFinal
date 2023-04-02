package com.MealPicker.mealpicker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealPickerServices {

    @Autowired
    private SeasonRepository seasonRepository;
    private MealRepository mealRepository;
    @Autowired
    private MealTimeRepository mealTimeRepository;


    public MealPickerServices(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public String getRandomMealBySeasonAndMealTime(String seasonName, String mealTimeName) {
        return mealRepository.findRandomMealBySeasonAndMealTime(seasonName, mealTimeName);
    }

    @Transactional
    @Modifying
    public void addNewMeal(String name) {
        mealRepository.addNewMeal(name);
    }

    @Transactional
    @Modifying
    public void addMealToSeasons(String name, List<String> seasonName) {
        Optional<Meal> meal = mealRepository.findByName(name);
        if (meal.isPresent()) {
            for (String s : seasonName) {
                Optional<Season> season = Optional.ofNullable(seasonRepository.findByName(s));
                if (season.isPresent()) {
                    meal.get().addSeason(season.get());
                }
            }
        }
    }

    @Transactional
    @Modifying
    public void addMealToMealTimes(int mealId, List<String> mealTimeName) {
        for (String s : mealTimeName) {
            Optional<MealTime> mealTime = Optional.ofNullable(mealTimeRepository.findByName(s));
            if (mealTime.isPresent()) {
                mealTime.get().addMeal(mealRepository.getOne(mealId));
            }
        }
    }
        }

