package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.IngredientCommand;
import recipeproject.cookbook.domain.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand>{

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if(ingredient == null) {
            return null;
        }

        final IngredientCommand ingredientCmd = new IngredientCommand();
        ingredientCmd.setId(ingredient.getId());
        if(ingredient.getRecipe() != null){
            ingredientCmd.setRecipeId(ingredient.getRecipe().getId());
        }
        ingredientCmd.setAmount(ingredient.getAmount());
        ingredientCmd.setDescription(ingredient.getDescription());
        ingredientCmd.setUom(uomConverter.convert(ingredient.getUom()));
        return ingredientCmd;
    }
}
