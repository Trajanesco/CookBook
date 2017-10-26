package recipeproject.cookbook.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import recipeproject.cookbook.repositories.UnitMeasureRepository;


import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureTestIT {

    @Autowired
    UnitMeasureRepository unitMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUom() throws Exception{
        Optional<UnitOfMeasure> uomOptional = unitMeasureRepository.findByUom("Pinch");

        assertEquals("Pinch", uomOptional.get().getUom());
    }
    @Test
    public void findByUomCup() throws Exception{
        Optional<UnitOfMeasure> uomOptional = unitMeasureRepository.findByUom("Cup");

        assertEquals("Cup", uomOptional.get().getUom());
    }
    @Test
    public void findByUomTea() throws Exception{
        Optional<UnitOfMeasure> uomOptional = unitMeasureRepository.findByUom("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getUom());
    }

}