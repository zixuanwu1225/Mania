import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    private JTextArea text;
    private JButton start;
    private JButton quit;

    public MenuPanel(){
        text.setLocation(500,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        JButton button = (JButton)src;
        String text = button.getText();
        if(text.equals("Start")){
            //call NewPanel class
        }
        if(text.equals("Quit")){
            //use the exit call thing
        }
        //make sure to add the listener somewhere idk
    }
}
