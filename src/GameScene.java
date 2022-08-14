import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameScene extends JPanel {
    protected final int PANEL_WIDTH = 350;
    protected final int PANEL_HEIGHT = 600;
    protected final int LINE_WIDTH = 10;
    protected final int LINE_HEIGHT = 40;
    protected final int LINE_SPACE = 25;
    private final int NUM_OF_LINES = (int) (PANEL_HEIGHT/(LINE_HEIGHT+LINE_SPACE))*LINE_HEIGHT;
    protected Image car;
    protected int xCar;
    protected Timer timer;
    protected TimerTask task;
    protected int yRandomCar=0;
    protected boolean isDrive;
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
        timer = new Timer();
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
        newCars(g);
    }

    public void newCars(Graphics g) {
            task = new TimerTask() {
                @Override
                public void run() {
                    Image randomCar = new ImageIcon("randomCar.png").getImage();
                    g.drawImage(randomCar, 0, yRandomCar, null);
                    moveCars(randomCar);
                    repaint();

                }
            };
            timer.scheduleAtFixedRate(task, 0, 4000 );

        }


    public void moveCars(Image car){
        yRandomCar+=10;
    }

    public void drive(){
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].y >= PANEL_HEIGHT) {
                lines[i].setBounds(lines[i].x, 0, lines[i].width, lines[i].height);
            }
            else {
                lines[i].setBounds(lines[i].x, lines[i].y + 10, lines[i].width, lines[i].height);
            }
        }
    }


    public class Listener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                isDrive=true;
                xCar += 10;
                drive();
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                isDrive=true;
                xCar -= 10;
                drive();
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP){
                isDrive=true;
                drive();
            }
            else {
                isDrive=false;
            }
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

}



