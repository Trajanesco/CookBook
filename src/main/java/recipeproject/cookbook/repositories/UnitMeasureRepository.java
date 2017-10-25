package recipeproject.cookbook.repositories;

import org.springframework.data.repository.CrudRepository;
import recipeproject.cookbook.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {


    Optional<UnitOfMeasure> findByUom(String uom);
}
