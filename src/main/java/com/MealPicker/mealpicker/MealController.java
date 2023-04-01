package com.MealPicker.mealpicker;

/*
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/mealpicker")

public class MealController {


    @Autowired
    private MealPickerServices mealPickerServices;


    @CrossOrigin(origins = "http://localhost:3000")
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
    }
*/
