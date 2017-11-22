package recipeproject.cookbook.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import recipeproject.cookbook.domain.Recipe;

public interface RecipeReactiveRepository extends ReactiveMongoRepository <Recipe, String>{
}
