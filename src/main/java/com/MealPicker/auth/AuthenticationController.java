package com.MealPicker.auth;

import com.MealPicker.mealpicker.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final AuthenticationService service;
    @Autowired
    private MealPickerServices mealPickerServices;

    private final MealRepository mealRepository;
    private final MealSeasonRepository mealSeasonRepository;
    private final SeasonRepository seasonRepository;
    private final MealMealTimeRepository mealMealTimeRepository;
    private final MealTimeRepository mealTimeRepository;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request, HttpServletResponse response
    ) {

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        return ResponseEntity.ok(service.register(request));

    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request, HttpServletResponse response
    ) {


        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        return ResponseEntity.ok(service.authenticate(request));

    }

    @GetMapping("/random")
    public ResponseEntity<String> getRandomMeal(@RequestParam("seasonName") String seasonName,
                                                @RequestParam("mealTimeName") String mealTimeName,
                                                HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        String meal = mealPickerServices.getRandomMealBySeasonAndMealTime(seasonName, mealTimeName);
        if (meal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meal);

    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewMealBySeasonAndMealTime(@RequestBody MealRequest mealRequest, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        String name = mealRequest.getName();
        List<String> seasonName = mealRequest.getSeasonName();
        List<String> mealTimeName = mealRequest.getMealTimeName();

        // Save the new meal to the database
        mealPickerServices.addNewMeal(name);

        // Save the meal's association with each season to the database
        mealPickerServices.addMealToSeasons(name, seasonName);

        // Save the meal's association with each meal time to the database
        Meal meal = mealRepository.findByName(name).orElse(null);
        if (meal != null) {
            mealPickerServices.addMealToMealTimes(meal.getId(), mealTimeName);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}