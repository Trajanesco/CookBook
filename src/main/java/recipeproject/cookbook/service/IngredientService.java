package recipeproject.cookbook.service;

import reactor.core.publisher.Mono;
import recipeproject.cookbook.commands.IngredientCommand;


public interface IngredientService {

    Mono<IngredientCommand> findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
    Mono<IngredientCommand> saveIngredientCommand(IngredientCommand ingredientCommand);
    Mono<Void> deleteById(String recipeId, String id);
}
