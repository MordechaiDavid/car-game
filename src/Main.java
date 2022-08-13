import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {



    public Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new GameScene());
        this.pack();
        this.setVisible(true);


    }



    public static void main(String[] args) {
       new Main();

    }


}
