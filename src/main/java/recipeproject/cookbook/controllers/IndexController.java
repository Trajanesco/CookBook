package recipeproject.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import recipeproject.cookbook.domain.Category;
import recipeproject.cookbook.domain.UnitOfMeasure;
import recipeproject.cookbook.repositories.CategoryRepository;
import recipeproject.cookbook.repositories.UnitMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitMeasureRepository unitMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitMeasureRepository unitMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitMeasureRepository = unitMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Chinese");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitMeasureRepository.findByUom("Teaspoon");

        System.out.println("CAT ID is:" + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
