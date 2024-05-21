package com.example.webclientspringboot.model;


import lombok.Data;


import java.util.List;

@Data

public class MultipleRecipes {
    private List<Recipe> recipes;
    private int total;
    private int skip;
    private int limit;
}
