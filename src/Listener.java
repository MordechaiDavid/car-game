import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Listener implements KeyListener {

    protected GameScene game;
    protected Sound sound;

    public Listener(GameScene game) {
        this.game = game;
        // sound = new Sound
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                //sound.play();
                game.isDrive=true;
                if (game.xCar+game.car.getWidth(null) < game.PANEL_WIDTH) {
                    game.xCar += 10;
                }
                game.drive();
                break;

            case KeyEvent.VK_LEFT:
                game.isDrive=true;
                if (game.xCar > 0) {
                    game.xCar -= 10;
                }
                game.drive();
                break;

            case KeyEvent.VK_UP:
                    //sound.play();
                    game.isDrive=true;
                game.drive();
                break;

            default:
                //sound.quite();
                game.isDrive=false;
        }
        game.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
