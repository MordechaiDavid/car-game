import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    protected final int PANEL_WIDTH = 350;
    protected final int PANEL_HEIGHT = 600;

    protected Image car;
    protected int xCar;
    protected Rectangle[] lines;


    public GameScene(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        car = new ImageIcon("car.png").getImage();
        xCar = PANEL_WIDTH/2;
        lines = new Rectangle[12];
        for (int i = 0, j = 0; i < lines.length; i++, j+=15) {
            lines[i] = new Rectangle(PANEL_WIDTH / 2, j, 10, 40);
            j += 40;
        }
        gameLoop();
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paint(g);
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

}
