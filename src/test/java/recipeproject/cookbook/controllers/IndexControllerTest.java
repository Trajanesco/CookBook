package recipeproject.cookbook.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import recipeproject.cookbook.service.RecipeService;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    @Mock
    Model model;

    @Mock
    RecipeService recipeService;

    IndexController controller;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {

        String viewName = controller.getIndexPage(model);

        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipies();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }

}