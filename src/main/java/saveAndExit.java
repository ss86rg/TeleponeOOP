public class saveAndExit extends Command {


        public saveAndExit(ConcoleUI concoleUI){
            super(concoleUI);
            description = "Сохранить и закрыть";
        }
        @Override
        public void execute() {
            concoleUI.saveAndExit();

        }

}
