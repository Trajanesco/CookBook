package recipeproject.cookbook.commands;

public class UnitOfMeasureCommand {
    private Long id;
    private String description;

    public UnitOfMeasureCommand() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
