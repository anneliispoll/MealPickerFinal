package com.MealPicker.mealpicker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealRequest {
    private String name;
    private List<String> seasonName;
    private List<String> mealTimeName;

}