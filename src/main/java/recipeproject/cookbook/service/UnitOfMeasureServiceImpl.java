package recipeproject.cookbook.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import recipeproject.cookbook.commands.UnitOfMeasureCommand;
import recipeproject.cookbook.converters.UnitOfMeasureToUnitOfMeasureCommand;
import recipeproject.cookbook.repositories.reactive.UnitOfMeasureReactiveRepository;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{

    private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureReactiveRepository = unitOfMeasureReactiveRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Flux<UnitOfMeasureCommand> listAllUoms() {
//        return StreamSupport.stream(unitMeasureRepository.findAll().spliterator(),false)
//                .map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());

        return unitOfMeasureReactiveRepository.findAll().map(unitOfMeasureToUnitOfMeasureCommand::convert);
    }
}
