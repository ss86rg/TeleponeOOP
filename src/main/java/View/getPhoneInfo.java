package View;

public class getPhoneInfo extends Command {

    public getPhoneInfo(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Список абонентов:";
    }
    @Override
    public void execute() {
        concoleUI.getPhoneInfo();
    }
}
