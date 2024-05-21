package com.example.webclientspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private int id;
    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int serving;
    private String difficulty;
    private String cuisine;
    private int caloriesPerServing;
    private List<String> tags;
    private int userId;
    private String image;
    private double rating;
    private int reviewCount;
    private List<String> mealType;
}
