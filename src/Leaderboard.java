import javax.swing.*;
import java.io.IOException;

public class Leaderboard extends JFrame {
    private JFrame frame;
    private JPanel list;
    private JTextArea leaderboard = new JTextArea();
    public Leaderboard(){
        frame = new JFrame();
        list = new JPanel();
        list.add(leaderboard);
        frame.add(list);
    }
    public void addList() throws IOException {
        NewPanel panel = new NewPanel();
        int score = panel.getScore();
        leaderboard.setText(leaderboard.getText()+"/n"+(""+score));//make so that it adds on new line
    }
}
