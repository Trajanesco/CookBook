package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.RecipeCommand;
import recipeproject.cookbook.domain.Category;
import recipeproject.cookbook.domain.Recipe;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{

    private final CategoryToCategoryCommand catConv;
    private final IngredientToIngredientCommand ingredientConv;
    private final NotesToNotesCommand notesConv;

    public RecipeToRecipeCommand(CategoryToCategoryCommand catConv, IngredientToIngredientCommand ingredientConv, NotesToNotesCommand notesConv) {
        this.catConv = catConv;
        this.ingredientConv = ingredientConv;
        this.notesConv = notesConv;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if(recipe == null) {
            return null;
        }
        final RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(recipe.getId());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setUrl(recipe.getSourceUrl());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setNotes(notesConv.convert(recipe.getNotes()));
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setImage(recipe.getImage());

        if(recipe.getCategories() != null && recipe.getCategories().size() >0){
            recipe.getCategories().forEach((Category category) -> recipeCommand.getCategories().add(catConv.convert(category)));
        }

        if(recipe.getIngredients() != null && recipe.getIngredients().size() > 0){
            recipe.getIngredients().forEach(ingredient -> recipeCommand.getIngredients().add(ingredientConv.convert(ingredient)));
        }

        return recipeCommand;
    }
}
