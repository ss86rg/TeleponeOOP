package View;

public abstract class Command {

    String description;
    ConcoleUI concoleUI;

    public Command(ConcoleUI concoleUI) {
        this.concoleUI = concoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
