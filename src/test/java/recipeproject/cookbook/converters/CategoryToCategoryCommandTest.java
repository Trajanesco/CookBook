package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.CategoryCommand;
import recipeproject.cookbook.domain.Category;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static  final Long LONG_VALUE = 1L;
    public static final String DESCRIPTION = "description";

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }


    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        Category cat = new Category();
        cat.setId(LONG_VALUE);
        cat.setDescription(DESCRIPTION);

        CategoryCommand catcmd = converter.convert(cat);

        assertEquals(LONG_VALUE, catcmd.getId());
        assertEquals(DESCRIPTION, catcmd.getDescription());
    }

}