package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.NotesCommand;
import recipeproject.cookbook.domain.Notes;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {
    public static final String ID_VALUE = "1";
    public static final String RECIPE_NOTES = "recipe notes";

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }



    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new Notes()));
    }
    @Test
    public void convert() throws Exception {
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        NotesCommand notesCmd = converter.convert(notes);

        assertEquals(ID_VALUE, notesCmd.getId());
        assertEquals(RECIPE_NOTES, notesCmd.getRecipeNotes());
    }

}