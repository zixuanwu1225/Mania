import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPanel extends JPanel implements ActionListener {
    private JTextArea text = new JTextArea();
    private JButton start = new JButton();
    private JButton leaderboard = new JButton();

    public MenuPanel(){
        text.setLocation(850,250);
        text.setText("Mania!");
        text.add(start);
        start.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        JButton button = (JButton)src;
        String text = button.getText();
        if(text.equals("Start")){
            try {
                MainGUI m =new MainGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(text.equals("Leaderboard")){
            Leaderboard l =new Leaderboard();
        }
        //make sure to add the listener somewhere idk
    }
}
