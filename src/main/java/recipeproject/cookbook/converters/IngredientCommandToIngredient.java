package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.IngredientCommand;
import recipeproject.cookbook.domain.Ingredient;
import recipeproject.cookbook.domain.Recipe;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>{

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        if(ingredientCommand == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientCommand.getId());
        if (ingredientCommand.getRecipeId() != null){
            Recipe recipe = new Recipe();
            recipe.setId(ingredientCommand.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }

        ingredient.setDescription(ingredientCommand.getDescription());
        ingredient.setAmount(ingredientCommand.getAmount());
        ingredient.setUom(uomConverter.convert(ingredientCommand.getUom()));
        return ingredient;
    }
}
