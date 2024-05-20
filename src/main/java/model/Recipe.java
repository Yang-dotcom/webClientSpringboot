package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private int id;
    private String name;
    private String[] ingredients;
    private String[] instructions;
    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int serving;
    private String difficulty;
    private String cuisine;
    private int caloriesPerServing;
    private String[] tags;
    private int userId;
    private String image;
    private double rating;
    private int reviewCount;
    private String[] mealType;
}
