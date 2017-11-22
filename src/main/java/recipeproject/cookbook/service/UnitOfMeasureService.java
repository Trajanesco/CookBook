package recipeproject.cookbook.service;

import reactor.core.publisher.Flux;
import recipeproject.cookbook.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
