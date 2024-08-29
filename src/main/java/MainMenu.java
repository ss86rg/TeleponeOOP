import java.util.ArrayList;
import java.util.List;

public class MainMenu {


        private List<Command> commandList;

        public MainMenu(ConcoleUI concoleUI) {
            commandList = new ArrayList<>();
            commandList.add(new Read(concoleUI));
            commandList.add(new getPhoneInfo(concoleUI));
            commandList.add(new AddUser(concoleUI));
            commandList.add(new saveAndExit(concoleUI));


        }

        public String menu(){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < commandList.size(); i++) {
                stringBuilder.append(i+1);
                stringBuilder.append(". ");
                stringBuilder.append(commandList.get(i).getDescription());
                stringBuilder.append("\n");
            }

            return stringBuilder.toString();
        }

        public void execute(int choice){
            Command command = commandList.get(choice-1);
            command.execute();
        }

        public int getSize(){
            return commandList.size();
        }

}
