import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    protected GameScene game;

    public Listener(GameScene game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            game.xCar += 10;
            game.drive();
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            game.xCar -= 10;
            game.drive();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            game.drive();
        }

        game.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
