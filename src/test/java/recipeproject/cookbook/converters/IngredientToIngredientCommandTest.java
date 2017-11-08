package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.IngredientCommand;
import recipeproject.cookbook.domain.Ingredient;
import recipeproject.cookbook.domain.Recipe;
import recipeproject.cookbook.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {
    public static final Long LONG_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final Long UOM_ID = 2L;
    public static final Recipe RECIPE = new Recipe();

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }


    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(LONG_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);

        IngredientCommand ingredientCmd = converter.convert(ingredient);

        assertNotNull(ingredientCmd);
        assertNotNull(ingredientCmd.getUom());
        assertEquals(LONG_VALUE, ingredientCmd.getId());
        assertEquals(DESCRIPTION, ingredientCmd.getDescription());
        assertEquals(AMOUNT, ingredientCmd.getAmount());
        assertEquals(UOM_ID, ingredientCmd.getUom().getId());
    }

    @Test
    public void convertWithNullUnitOfMeasure() throws Exception{
        Ingredient ingredient = new Ingredient();
        ingredient.setId(LONG_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);

        IngredientCommand ingredientCmd = converter.convert(ingredient);

        assertNotNull(ingredientCmd);
        assertNull(ingredientCmd.getUom());
        assertEquals(LONG_VALUE, ingredientCmd.getId());
        assertEquals(DESCRIPTION, ingredientCmd.getDescription());
        assertEquals(AMOUNT, ingredientCmd.getAmount());


    }

}