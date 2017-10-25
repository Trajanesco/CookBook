package recipeproject.cookbook.repositories;

import org.springframework.data.repository.CrudRepository;
import recipeproject.cookbook.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
}
