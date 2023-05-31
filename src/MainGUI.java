import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainGUI extends JPanel {
    public MainGUI() throws IOException {
        JFrame frame = buildFrame();
        BufferedImage image = ImageIO.read(new File("C:\\Users\\wzixu\\IdeaProjects\\Mania\\src\\Down.png"));
        image = new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB);
        BufferedImage finalImage = image;
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(finalImage, 50, 50, null);
            }
        };
        frame.add(pane);
    }
    public static JFrame buildFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }
}
