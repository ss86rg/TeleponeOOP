import View.View;
import View.ConcoleUI;

import static java.awt.SystemColor.menu;


public class Main {
    public static void main(String[] args) {
       View view = new ConcoleUI(menu);
       view.start();

    }

}
