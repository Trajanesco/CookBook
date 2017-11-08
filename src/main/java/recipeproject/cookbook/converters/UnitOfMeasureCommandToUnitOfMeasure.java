package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.UnitOfMeasureCommand;
import recipeproject.cookbook.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand uomCmd) {
        if(uomCmd == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uomCmd.getId());
        uom.setUom(uomCmd.getDescription());
        return uom;
    }
}
