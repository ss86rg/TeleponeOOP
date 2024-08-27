package View;

public class AddUser extends Command {
    public AddUser(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Введите сведения об абоненте:";
    }

    @Override
    public void execute() {
        concoleUI.AddUser();
    }


}
