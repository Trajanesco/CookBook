package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.CategoryCommand;
import recipeproject.cookbook.domain.Category;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {
    public static  final Long LONG_VALUE = 1L;
    public static final String DESCRIPTION = "description";

    CategoryCommandToCategory converter;



    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }


    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        CategoryCommand catCmd = new CategoryCommand();
        catCmd.setId(LONG_VALUE);
        catCmd.setDescription(DESCRIPTION);

        Category cat = converter.convert(catCmd);

        assertEquals(LONG_VALUE, cat.getId());
        assertEquals(DESCRIPTION, cat.getDescription());


    }

}