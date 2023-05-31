import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewPanel extends JPanel {
    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;

    public NewPanel() throws IOException {
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        image1 = ImageIO.read(new File("src/Down-removebg-preview.png"));
        image2 = ImageIO.read(new File("src/Left.png"));
        image3 = ImageIO.read(new File("src/Up.png"));
        image4 = ImageIO.read(new File("src/Right.png"));
        repaint();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image1, 20, 860, 100, 100, null);
        g2.drawImage(image2, 140, 860, 100, 100, null);
        g2.drawImage(image3, 260, 860, 100, 100, null);
        g2.drawImage(image4, 380, 860, 100, 100, null);
        g2.drawImage(image1, 20, 0, 100, 100, null);
        g2.drawImage(image2, 140, 0, 100, 100, null);
        g2.drawImage(image3, 260, 0, 100, 100, null);
        g2.drawImage(image4, 380, 0, 100, 100, null);
    }
}
