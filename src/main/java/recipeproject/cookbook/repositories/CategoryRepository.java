package recipeproject.cookbook.repositories;

import org.springframework.data.repository.CrudRepository;
import recipeproject.cookbook.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long>{


    Optional<Category> findByDescription(String description);
}
