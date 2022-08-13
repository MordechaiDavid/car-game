import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel {
    protected final int PANEL_WIDTH = 350;
    protected final int PANEL_HEIGHT = 600;
    protected final int LINE_WIDTH = 10;
    protected final int LINE_HEIGHT = 40;
    protected final int LINE_SPACE = 25;
    private final int NUM_OF_LINES = (int) (PANEL_HEIGHT/(LINE_HEIGHT+LINE_SPACE))*LINE_HEIGHT;

    protected Image car;
    protected int xCar;

    protected Rectangle[] lines;


    public GameScene(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        car = new ImageIcon("car.png").getImage();
        xCar = PANEL_WIDTH/2;
        lines = new Rectangle[NUM_OF_LINES];
        for (int i = 0, j = 0; i < lines.length; i++, j+=LINE_SPACE) {
            lines[i] = new Rectangle(PANEL_WIDTH / 2, j, LINE_WIDTH, LINE_HEIGHT);
            j += LINE_HEIGHT;
        }
        this.addKeyListener(new Listener());
        this.setFocusable(true);
        this.requestFocus();

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setPaint(Color.orange);
        g.setStroke(new BasicStroke(5));
        g.drawLine(15, 0, 15, PANEL_HEIGHT);
        g.drawLine(PANEL_WIDTH-15, 0, PANEL_WIDTH-15, PANEL_HEIGHT);
        g.setPaint(Color.white);
        for (int i = 0; i < lines.length; i++) {
            g.fillRect( lines[i].x, lines[i].y, lines[i].width,lines[i].height);
        }
        g.drawImage(car, xCar, PANEL_HEIGHT/2,  null);

    }


    public class Listener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT )
                xCar+=10;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                xCar-=10;
            if (e.getKeyCode() == KeyEvent.VK_UP){
                for (int i = 0; i < lines.length; i++) {
                    if (lines[i].y >= PANEL_HEIGHT) {
                        lines[i].setBounds(lines[i].x, 0, lines[i].width, lines[i].height);
                    }
                    else {
                        lines[i].setBounds(lines[i].x, lines[i].y + 10, lines[i].width, lines[i].height);
                    }
                }
            }
            repaint();
            }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

}


    /*

    public void gameLoop(){
        new Thread( ()-> {
            Listener listener = new Listener(lines, xCar);
            this.addKeyListener(listener);
            this.setFocusable(true);
            this.requestFocus();
            while (true) {
                try {
                    Thread.sleep(70);
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

     */


