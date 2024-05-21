package com.example.webclientspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.webclientspringboot.service.RecipesService;

@Slf4j
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipesService recipesService;

    public RecipeController(RecipesService myService){
        this.recipesService = myService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable int id){
        return ResponseEntity.ok(recipesService.getRecipe(id));
    }

    @GetMapping()
    public ResponseEntity<?> getRecipes(){
        return ResponseEntity.ok(recipesService.getAllRecipes());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchRecipes(@RequestParam String keyword){
        return ResponseEntity.ok(recipesService.searchRecipes(keyword));
    }




}
