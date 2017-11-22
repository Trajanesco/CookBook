package recipeproject.cookbook.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Notes {


    @Id
    private String id;
    private String recipeNotes;


    public Notes() {
    }


}
