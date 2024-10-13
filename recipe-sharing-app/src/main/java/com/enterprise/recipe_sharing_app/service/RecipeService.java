package com.enterprise.recipe_sharing_app.service;

import com.enterprise.recipe_sharing_app.model.Recipe;
import com.enterprise.recipe_sharing_app.model.User;

import java.util.List;

public interface RecipeService {

     Recipe createRecipe(Recipe recipe,User user);

     Recipe findRecipeById(Long id) throws Exception;

     void deleteRecipe(Long id) throws Exception;

     Recipe updateRecipe(Recipe recipe,Long id) throws Exception;

     List<Recipe> findAllRecipe();

     Recipe likeRecipe(Long recipeId,User user) throws Exception;


}
