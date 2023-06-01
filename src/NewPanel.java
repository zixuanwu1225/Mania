import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;

public class NewPanel extends JPanel implements ActionListener, KeyListener {

    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private int newY = 0;
    private int chance = (int)(Math.random()*4)+1;

    public NewPanel() throws IOException {
        addKeyListener(this);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        image1 = ImageIO.read(new File("src/Down-removebg-preview.png"));
        image2 = ImageIO.read(new File("src/Left.png"));
        image3 = ImageIO.read(new File("src/Up.png"));
        image4 = ImageIO.read(new File("src/Right.png"));
        repaint();
        /*new Thread( () -> {
            for(int i = 0;i<10000;i++){
                int chance = (int)(Math.random()*4)+1;
                if(chance==1){
                    newY = newY+20;
                    newY3 = newY3+20;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(chance==2){
                    newY1 = newY1+20;
                    newY2 = newY2+20;
                    newY3 = newY3+20;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(chance==3){
                    newY = newY+20;
                    newY2 = newY2+20;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(chance==4){
                    newY1 = newY1+20;
                    newY2 = newY2+20;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                repaint();
            }
        }).start();*/

        //try creating new thread + new method that draws another image
        new Thread( () -> {

            while(newY!=1080){

                newY+=20;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                //make listener so that when the right key is pressed, will delete the image and send out another one.
                //also make it so that Thread.sleep decreases as time passes
                //when correct key is clicked at the right time, change chance
                //OPTIONAL:make it so that multiple images will appear on the same lane
            }
            //make code to say you failed
        }).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image1, 20, 660, 100, 100, null);
        g2.drawImage(image2, 140, 660, 100, 100, null);
        g2.drawImage(image3, 260, 660, 100, 100, null);
        g2.drawImage(image4, 380, 660, 100, 100, null);
        g2.drawImage(image1, 20, 0, 100, 100, null);
        g2.drawImage(image2, 140, 0, 100, 100, null);
        g2.drawImage(image3, 260, 0, 100, 100, null);
        g2.drawImage(image4, 380, 0, 100, 100, null);
        if(chance==1){
            g2.drawImage(image1, 20, newY, 100, 100, null);
        }
        else if(chance==2){
            g2.drawImage(image2, 140, newY, 100, 100, null);
        }
        else if(chance==3){
            g2.drawImage(image3, 260, newY, 100, 100, null);
        }
        else if(chance==4){
            g2.drawImage(image4, 380, newY, 100, 100, null);
        }
    }
    public void actionPerformed(ActionEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        if(e.getExtendedKeyCode() ==  KeyEvent.VK_F/*&&image1.getMinY()<300*/){
            chance = (int)(Math.random()*4)+1;
            repaint();
            newY=0;
            System.out.println("f");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
