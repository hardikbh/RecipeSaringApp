package com.enterprise.recipe_sharing_app.controller;

import com.enterprise.recipe_sharing_app.model.Recipe;
import com.enterprise.recipe_sharing_app.model.User;
import com.enterprise.recipe_sharing_app.service.RecipeService;
import com.enterprise.recipe_sharing_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService  recipeService;
    @Autowired
    private UserService userService;

    @PostMapping("/user/{userId}")
    public Recipe createRecipe(@RequestBody  Recipe recipe, @PathVariable Long userId)
    {

        User user = userService.findUserById(userId);
        Recipe createdRecipe = recipeService.createRecipe(recipe,user);

        return createdRecipe;

    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipeByid(@PathVariable Long recipeId) throws Exception
    {
        return recipeService.findRecipeById(recipeId);
    }
    @GetMapping()
    List<Recipe> getAllRecipe()
    {
        List<Recipe> recipes= recipeService.findAllRecipe();
        return recipes;
    }
    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception
    {
        recipeService.deleteRecipe(recipeId);
        return "Recipe is deleted";
    }
    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@RequestBody  Recipe recipe, @PathVariable Long recipeId) throws Exception
    {


        Recipe updatedRecipe = recipeService.updateRecipe(recipe,recipeId);

        return updatedRecipe;

    }

    @PutMapping("/like/{recipeId}/user/{userId}")
    public Recipe likeRecipe(@PathVariable  Long recipeId, @PathVariable Long userId) throws Exception
    {

        User user = userService.findUserById(userId);
        Recipe likedRecipe = recipeService.likeRecipe(recipeId,user);

        return likedRecipe;

    }

}
