package recipeproject.cookbook.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import recipeproject.cookbook.commands.NotesCommand;
import recipeproject.cookbook.domain.Notes;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {
        if(notes == null) {
            return null;
        }

        final NotesCommand notesCmd = new NotesCommand();
        notesCmd.setId(notes.getId());
        notesCmd.setRecipeNotes(notes.getRecipeNotes());
        return notesCmd;

    }
}
