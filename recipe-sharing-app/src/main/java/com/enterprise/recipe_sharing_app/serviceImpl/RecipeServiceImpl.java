package com.enterprise.recipe_sharing_app.serviceImpl;


import com.enterprise.recipe_sharing_app.Execptions.UserNotFound;
import com.enterprise.recipe_sharing_app.Repository.RecipeRepository;
import com.enterprise.recipe_sharing_app.Repository.UserRepository;
import com.enterprise.recipe_sharing_app.model.Recipe;
import com.enterprise.recipe_sharing_app.model.User;
import com.enterprise.recipe_sharing_app.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {


        Recipe createdRecipe = Recipe.builder().title(recipe.getTitle()).image(recipe.getImage()).description(recipe.getDescription()).vegetarian(recipe.isVegetarian()).user(user).createdAt(LocalDateTime.now()).likes(recipe.getLikes()).build();


        return recipeRepository.save(createdRecipe);



    }

    @Override
    public Recipe findRecipeById(Long id) throws Exception {
       Optional<Recipe> recipe = recipeRepository.findById(id);
       if(recipe.isPresent())
       {
           return recipe.get();
       }
       throw new Exception("No recipe is present with "+ id);
    }

    @Override
    public void deleteRecipe(Long id) throws Exception {
        findRecipeById(id);
        recipeRepository.deleteById(id);

    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
        Recipe oldRecipe =  findRecipeById(id);
        if(recipe.getTitle()!=null)
        {
            oldRecipe.setTitle(recipe.getTitle());
        }
        if(recipe.getImage()!=null)
        {
            oldRecipe.setTitle(recipe.getImage());
        }
        if(recipe.getDescription()!=null)
        {
            oldRecipe.setTitle(recipe.getDescription());
        }
        return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe likeRecipe(Long recipeId, User user) throws Exception {

        Recipe recipe = findRecipeById(recipeId);
        if(recipe.getLikes().contains(user.getId()))
        {
            recipe.getLikes().remove(user.getId());
        }
        else {
            recipe.getLikes().add(user.getId());
        }
        recipeRepository.save(recipe);
        return recipe;
    }
}
