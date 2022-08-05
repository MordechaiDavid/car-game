import javax.swing.*;

public class Window extends JFrame  {

    public Window(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Panel());
        this.setVisible(true);
    }



    public static void main(String[] args) {
       new Window();

    }
}
