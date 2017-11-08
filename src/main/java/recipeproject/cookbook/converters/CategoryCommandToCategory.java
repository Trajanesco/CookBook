package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.CategoryCommand;
import recipeproject.cookbook.domain.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if(categoryCommand == null) {
            return null;
        }

        final Category cat = new Category();
        cat.setId(categoryCommand.getId());
        cat.setDescription(categoryCommand.getDescription());
        return cat;
    }
}
