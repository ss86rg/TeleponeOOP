public class Read extends Command{

    public Read(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "загрузить общий список: ";
    }

    @Override
    public void execute() {
        concoleUI.Read();
    }
}
