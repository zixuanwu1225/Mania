import javax.swing.*;
import java.io.IOException;

public class MainMenu {
    private JFrame menu = buildFrame();
    public MainMenu() throws IOException {
        MenuPanel menuPanel = new MenuPanel();
        menu.add(menuPanel);
        menu.setVisible(true);
    }
    public static JFrame buildFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(720,0);
        frame.setSize(500, 1080);
        frame.setVisible(true);
        return frame;
    }
}
