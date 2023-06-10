import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainGUI {
    private JFrame frame = buildFrame();
    public MainGUI() throws IOException {

        NewPanel panel = new NewPanel();
        frame.add(panel);
        frame.addKeyListener(panel);
        frame.setVisible(true);
    }
    public static JFrame buildFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(720,0);
        frame.setSize(500, 1080);
        frame.setVisible(true);
        return frame;
    }
    public static BufferedImage resize(BufferedImage img,int newW,int newH){
        Image temp = img.getScaledInstance(newW,newH,Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW,newH,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(temp,0,0,null);
        g2d.dispose();
        return dimg;
    }

    public JFrame getFrame() {
        return frame;
    }
}
