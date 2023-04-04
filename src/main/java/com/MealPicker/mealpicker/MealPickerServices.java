package com.MealPicker.mealpicker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealPickerServices {

    @Autowired
    private SeasonRepository seasonRepository;
    private MealRepository mealRepository;
    @Autowired
    private MealTimeRepository mealTimeRepository;


    public MealPickerServices(MealRepository mealRepository, MealTimeRepository mealTimeRepository,
                              SeasonRepository seasonRepository) {
        this.mealRepository = mealRepository;
        this.mealTimeRepository = mealTimeRepository;
        this.seasonRepository = seasonRepository;
    }


    public String getRandomMealBySeasonAndMealTime(String seasonName, String mealTimeName) {
        return mealRepository.findRandomMealBySeasonAndMealTime(seasonName, mealTimeName);
    }

    @Transactional
    @Modifying
    public Meal addNewMeal(String name) {
        Meal meal = new Meal(name);
        return mealRepository.save(meal);
    }

    public Integer findMealIdByName (String name) {
        return mealRepository.findIdByName(name);
    }

    public List<Integer> getSeasonIdsByNames(List<String> seasonNames) {
        List<Integer> seasonIds = new ArrayList<>();
        for (String seasonName : seasonNames) {
            Optional<Season> season = seasonRepository.findByName(seasonName);
            if (season.isPresent()) {
                seasonIds.add(season.get().getId());
            }
        }
        return seasonIds;
    }


    @Transactional
    @Modifying
    public void addMealToSeasons(int mealId, List<Integer> seasonIds) {
        mealRepository.addMealToSeasons(mealId, seasonIds);
    }


    @Transactional
    @Modifying
    public List<Integer> getMealTimeIdsByNames(List<String> mealTimeNames) {
        List<Integer> mealTimeIds = new ArrayList<>();
        for (String mealTimeName : mealTimeNames) {
            Optional<MealTime> mealTime = mealTimeRepository.findByName(mealTimeName);
            if (mealTime.isPresent()) {
                mealTimeIds.add(mealTime.get().getId());
            }
        }
        return mealTimeIds;
    }

    @Transactional
    @Modifying
    public void addMealToMealTimes(int mealId, List<Integer> mealTimeIds) {
                mealRepository.addMealToMealTimes(mealId, mealTimeIds);
            }
        }





