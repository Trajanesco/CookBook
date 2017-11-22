package recipeproject.cookbook.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category cat;

    @Before
    public void setUp(){
       cat = new Category();
    }

    @Test
    public void getId() throws Exception {
        String idValue = "4";
        cat.setId(idValue);
        assertEquals(idValue, cat.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }

}