import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    protected Rectangle[] lines;
    protected int xCar;

    Listener(Rectangle[] lines, int xCar){
        this.lines = lines;
        this.xCar = xCar;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_2)
                xCar+=3;


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}
