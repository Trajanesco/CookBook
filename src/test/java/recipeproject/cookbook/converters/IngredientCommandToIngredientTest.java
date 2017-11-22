package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.IngredientCommand;
import recipeproject.cookbook.commands.UnitOfMeasureCommand;
import recipeproject.cookbook.domain.Ingredient;
import recipeproject.cookbook.domain.Recipe;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    public static final String ID_VALUE = "1";
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String UOM_ID = "2";
    public static final Recipe RECIPE = new Recipe();

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }


    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        IngredientCommand ingredientCmd = new IngredientCommand();
        ingredientCmd.setId(ID_VALUE);
        ingredientCmd.setAmount(AMOUNT);
        ingredientCmd.setDescription(DESCRIPTION);
        UnitOfMeasureCommand uomCmd = new UnitOfMeasureCommand();
        uomCmd.setId(UOM_ID);
        ingredientCmd.setUom(uomCmd);

        Ingredient ingredient = converter.convert(ingredientCmd);

        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUnitOfMeasure() throws Exception{
        IngredientCommand ingredientCmd = new IngredientCommand();
        ingredientCmd.setId(ID_VALUE);
        ingredientCmd.setAmount(AMOUNT);
        ingredientCmd.setDescription(DESCRIPTION);
        ingredientCmd.setUom(null);

        Ingredient ingredient = converter.convert(ingredientCmd);

        assertNotNull(ingredient);
        assertNull(ingredientCmd.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());

    }

}