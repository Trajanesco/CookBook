package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.RecipeCommand;
import recipeproject.cookbook.domain.*;

import static org.junit.Assert.*;

public class RecipeToRecipeCommandTest {

    public static  final Long LONG_VALUE = 1L;
    public static final Integer PREP_TIME = Integer.valueOf("5");
    public static final Integer COOK_TIME = Integer.valueOf("8");
    public static final String DESCRIPTION = "description";
    public static final String DIRECTIONS = "directions";
    public static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    public static final Integer SERVINGS = Integer.valueOf("4");
    public static final String SOURCE = "source";
    public static final String URL = "www.url.com";
    public static final Long CAT_ID = 1L;
    public static final Long INGRED1_ID = 2L;
    public static final Long INGRED2_ID = 3L;
    public static final Long NOTES_ID = 4L;

    RecipeToRecipeCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }


    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    public void convert() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(LONG_VALUE);
        recipe.setCookTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setSourceUrl(URL);

        Notes notes = new Notes();
        notes.setId(NOTES_ID);
        recipe.setNotes(notes);

        Category category = new Category();
        category.setId(CAT_ID);
        recipe.getCategories().add(category);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGRED1_ID);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGRED2_ID);

        recipe.getIngredients().add(ingredient);
        recipe.getIngredients().add(ingredient2);

        RecipeCommand recipeCmd  = converter.convert(recipe);

        assertNotNull(recipeCmd);
        assertEquals(LONG_VALUE, recipeCmd.getId());
        assertEquals(COOK_TIME, recipeCmd.getCookTime());
        assertEquals(PREP_TIME, recipeCmd.getPrepTime());
        assertEquals(DESCRIPTION, recipeCmd.getDescription());
        assertEquals(DIFFICULTY, recipeCmd.getDifficulty());
        assertEquals(DIRECTIONS, recipeCmd.getDirections());
        assertEquals(SERVINGS, recipeCmd.getServings());
        assertEquals(SOURCE, recipeCmd.getSource());
        assertEquals(URL, recipeCmd.getUrl());
        assertEquals(NOTES_ID, recipeCmd.getNotes().getId());
        assertEquals(1, recipeCmd.getCategories().size());

    }

}