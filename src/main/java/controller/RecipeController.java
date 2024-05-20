package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RecipesService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipesService myService;

    public RecipeController(RecipesService myService){
        this.myService = myService;
    }

    @GetMapping("/{id}")
    public getRecipe(@PathVariable int id)


}
