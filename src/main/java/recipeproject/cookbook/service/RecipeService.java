package recipeproject.cookbook.service;

import recipeproject.cookbook.commands.RecipeCommand;
import recipeproject.cookbook.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipies();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(Long l);
    void deleteById(Long id);
}
