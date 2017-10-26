package recipeproject.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import recipeproject.cookbook.service.RecipeServiceImpl;



@Controller
public class IndexController {

    private final RecipeServiceImpl recipeServiceImpl;

    public IndexController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeServiceImpl.getRecipies());

        return "index";
    }
}
