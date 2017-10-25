package recipeproject.cookbook.repositories;

import org.springframework.data.repository.CrudRepository;
import recipeproject.cookbook.domain.UnitOfMeasure;

public interface UnitMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
