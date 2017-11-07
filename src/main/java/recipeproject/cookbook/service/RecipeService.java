package recipeproject.cookbook.service;

import recipeproject.cookbook.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipies();
    Recipe findById(Long l);
}
