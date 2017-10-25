package recipeproject.cookbook.repositories;

import org.springframework.data.repository.CrudRepository;
import recipeproject.cookbook.domain.Recipe;

public interface Reciperepository extends CrudRepository<Recipe, Long>{

}
