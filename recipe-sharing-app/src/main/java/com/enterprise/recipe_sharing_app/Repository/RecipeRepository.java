package com.enterprise.recipe_sharing_app.Repository;

import com.enterprise.recipe_sharing_app.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
