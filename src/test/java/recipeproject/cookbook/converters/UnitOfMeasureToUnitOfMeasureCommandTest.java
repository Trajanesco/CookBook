package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.UnitOfMeasureCommand;
import recipeproject.cookbook.domain.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long LONG_VALUE = 1L;
    public static final String DESCRIPTION = "description";

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }



    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
    @Test
    public void convert() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();

        uom.setId(LONG_VALUE);
        uom.setUom(DESCRIPTION);

        UnitOfMeasureCommand uomCmd = converter.convert(uom);

        assertEquals(LONG_VALUE, uomCmd.getId());
        assertEquals(DESCRIPTION, uomCmd.getDescription());
    }

}