import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu extends JFrame implements ActionListener {
    private JFrame menu = buildFrame();
    private JPanel panel = new JPanel();
    private JTextArea text = new JTextArea();
    private JButton start = new JButton();
    public MainMenu() throws IOException{
        MenuPanel m = new MenuPanel();
        text.setText("Mania!");
        panel.add(text);
        start.setText("Start");
        panel.add(start);
        menu.add(panel);
        start.addActionListener(this);
        menu.setVisible(true);
    }
    public static JFrame buildFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(720,100);
        frame.setSize(500, 600);
        frame.setVisible(true);
        return frame;
    }
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        JButton button = (JButton)src;
        String text = button.getText();
        if(text.equals("Start")){
            new Thread( () -> {
                try {
                    MainGUI m = new MainGUI();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }).start();
        }
        if(text.equals("Leaderboard")){
            Leaderboard l =new Leaderboard();
        }
        //make sure to add the listener somewhere idk
    }
}
