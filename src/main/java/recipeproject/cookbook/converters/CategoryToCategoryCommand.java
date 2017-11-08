package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.CategoryCommand;
import recipeproject.cookbook.domain.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand>{

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category category) {
        if(category == null) {
            return null;
        }

        final CategoryCommand catCmd = new CategoryCommand();
        catCmd.setId(category.getId());
        catCmd.setDescription(category.getDescription());
        return catCmd;
    }
}
