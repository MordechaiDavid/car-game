import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.cert.PolicyNode;

public class Panel extends JPanel {
    private Image img;

    public Panel(){
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img = new ImageIcon("C:\\car_game\\images\\car.jfif").getImage();
        g.setColor(Color.pink);
        g.drawImage(img, 50, 50, 50, 100, this);

    }


}
