package recipeproject.cookbook.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import recipeproject.cookbook.commands.IngredientCommand;
import recipeproject.cookbook.converters.IngredientCommandToIngredient;
import recipeproject.cookbook.converters.IngredientToIngredientCommand;
import recipeproject.cookbook.converters.UnitOfMeasureCommandToUnitOfMeasure;
import recipeproject.cookbook.converters.UnitOfMeasureToUnitOfMeasureCommand;
import recipeproject.cookbook.domain.Ingredient;
import recipeproject.cookbook.domain.Recipe;
import recipeproject.cookbook.repositories.RecipeRepository;
import recipeproject.cookbook.repositories.UnitMeasureRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitMeasureRepository unitMeasureRepository;

    IngredientService ingredientService;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository, unitMeasureRepository, ingredientCommandToIngredient);
    }

    @Test
    public void findByRecipeIdAndId()throws Exception{
    }

    @Test
    public void findByRecipeIdAndGoodPath()throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId("1");

        Ingredient ing1 = new Ingredient();
        ing1.setId("1");
        Ingredient ing2 = new Ingredient();
        ing2.setId("2");
        Ingredient ing3 = new Ingredient();
        ing3.setId("3");

        recipe.addIngredient(ing1);
        recipe.addIngredient(ing2);
        recipe.addIngredient(ing3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);

        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId("1", "3").block();

        assertEquals("3", ingredientCommand.getId());
        assertEquals("1", ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyString());
    }

    @Test
    public void testSaveRecipeCommand() throws Exception{
        IngredientCommand command = new IngredientCommand();

        command.setId("3");
        command.setRecipeId("2");

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId("3");

        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command).block();

        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, times(1)).save(any(Recipe.class));

    }

    @Test
    public void testDeleteById() throws Exception{
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();

        ingredient.setId("3");
        recipe.addIngredient(ingredient);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);

        ingredientService.deleteById("1", "3");

        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }


}