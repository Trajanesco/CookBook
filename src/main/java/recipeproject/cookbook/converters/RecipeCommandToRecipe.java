package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.RecipeCommand;
import recipeproject.cookbook.domain.Recipe;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>{

    private final CategoryCommandToCategory catConv;
    private final IngredientCommandToIngredient ingredientConv;
    private final NotesCommandToNotes notesConv;

    public RecipeCommandToRecipe(CategoryCommandToCategory catConv, IngredientCommandToIngredient ingredientConv, NotesCommandToNotes notesConv) {
        this.catConv = catConv;
        this.ingredientConv = ingredientConv;
        this.notesConv = notesConv;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if(recipeCommand == null){
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setSource(recipeCommand.getSource());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSourceUrl(recipeCommand.getUrl());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setNotes(notesConv.convert(recipeCommand.getNotes()));
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setDifficulty(recipeCommand.getDifficulty());

        if(recipeCommand.getCategories() != null && recipeCommand.getCategories().size() > 0){
            recipeCommand.getCategories().forEach(category -> recipe.getCategories().add(catConv.convert(category)));
        }

        if(recipeCommand.getIngredients() != null && recipeCommand.getIngredients().size() > 0){
            recipeCommand.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientConv.convert(ingredient)));
        }

        return recipe;
    }
}
