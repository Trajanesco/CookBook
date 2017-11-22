package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.CategoryCommand;
import recipeproject.cookbook.commands.IngredientCommand;
import recipeproject.cookbook.commands.NotesCommand;
import recipeproject.cookbook.commands.RecipeCommand;
import recipeproject.cookbook.domain.Difficulty;
import recipeproject.cookbook.domain.Recipe;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {
    public static final String ID_VALUE = "1";
    public static final Integer PREP_TIME = Integer.valueOf("5");
    public static final Integer COOK_TIME = Integer.valueOf("8");
    public static final String DESCRIPTION = "description";
    public static final String DIRECTIONS = "directions";
    public static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    public static final Integer SERVINGS = Integer.valueOf("4");
    public static final String SOURCE = "source";
    public static final String URL = "www.url.com";
    public static final String CAT_ID = "1";
    public static final String INGRED1_ID = "2";
    public static final String INGRED2_ID = "3";
    public static final String NOTES_ID = "4";

    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }


    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID_VALUE);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notesCmd = new NotesCommand();
        notesCmd.setId(NOTES_ID);
        recipeCommand.setNotes(notesCmd);

        CategoryCommand category = new CategoryCommand();
        category.setId(CAT_ID);
        recipeCommand.getCategories().add(category);

        IngredientCommand ingredient = new IngredientCommand();
        ingredient.setId(INGRED1_ID);

        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(INGRED2_ID);

        recipeCommand.getIngredients().add(ingredient);
        recipeCommand.getIngredients().add(ingredient2);

        Recipe recipe  = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID_VALUE, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getSourceUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(1, recipe.getCategories().size());

    }

}