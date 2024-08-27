package View;

import View.Command;
import View.ConcoleUI;

public class GetPhoneInfo extends Command {

    public GetPhoneInfo(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Получить список контактов:";
    }


    @Override
    public void execute() { concoleUI.getPhoneInfo();

    }
}
