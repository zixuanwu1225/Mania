import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;

public class NewPanel extends JPanel implements ActionListener, KeyListener {

    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image12 = ImageIO.read(new File("src/Down-removebg-preview.png"));
    private BufferedImage image23 = ImageIO.read(new File("src/Left.png"));
    private BufferedImage image34 = ImageIO.read(new File("src/Up.png"));
    private BufferedImage image45 = ImageIO.read(new File("src/Right.png"));
    private int milli = 30;
    private int score = 0;
    private int highScore=0;
    private int newY = 0;
    private int image1newY = 0;
    private int image2newY = 0;
    private int image3newY = 0;
    private int image4newY = 0;
    private boolean cooldown = false;
    private int chance = (int)(Math.random()*4)+1;
    private static int[] scores = new int[1];

    public NewPanel() throws IOException {
        //addKeyListener(this);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        image1 = ImageIO.read(new File("src/Down-removebg-preview.png"));
        image2 = ImageIO.read(new File("src/Left.png"));
        image3 = ImageIO.read(new File("src/Up.png"));
        image4 = ImageIO.read(new File("src/Right.png"));
        repaint();


        //try creating new thread + new method that draws another image
        new Thread( () -> {

            while(newY!=1080){
                newY+=20;
                getImageY();
                try {
                    Thread.sleep(milli);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                //make listener so that when the right key is pressed, will delete the image and send out another one.
                //also make it so that Thread.sleep decreases as time passes
                //when correct key is clicked at the right time, change chance
                //OPTIONAL:make it so that multiple images will appear on the same lane
            }
            Leaderboard l = new Leaderboard();
            try {
                l.addList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //make code to say you failed
        }).start();
        new Thread( () -> {
            if(cooldown){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cooldown=false;
            }
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
            g2.drawImage(image12, 20, newY, 100, 100, null);
        }
        else if(chance==2){
            g2.drawImage(image23, 140, newY, 100, 100, null);
        }
        else if(chance==3){
            g2.drawImage(image34, 260, newY, 100, 100, null);
        }
        else if(chance==4){
            g2.drawImage(image45, 380, newY, 100, 100, null);
        }
    }
    public void actionPerformed(ActionEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public int getHighScore() {
        return highScore;
    }

    public int getScore() {
        return score;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()/*&&image1.getMinY()<300*/){
            case KeyEvent.VK_D:
                if(image1newY>500){
                    returnToTop();
                    fileWriter();
                    score++;
                }
                break;
            case KeyEvent.VK_F:
                if(image2newY>500){
                    returnToTop();
                    fileWriter();
                    score++;
                }
                break;
            case KeyEvent.VK_J:
                if(image3newY>500){
                    returnToTop();
                    fileWriter();
                    score++;
                }
                break;
            case KeyEvent.VK_K:
                if(image4newY>500){
                    returnToTop();
                    fileWriter();
                    score++;
                }
                break;
            case KeyEvent.VK_SPACE:
                if(cooldown){
                    //make warning saying that it is on cooldown
                }
                else{
                    slowDown();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void returnToTop(){
        chance = (int)(Math.random()*4)+1;
        repaint();
        newY=0;
        image1newY=0;
        image2newY=0;
        image3newY=0;
        image4newY=0;
        milli-=1;
    }
    public void slowDown(){
        milli+=10;
        cooldown = true;
    }
    public void fileWriter(){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            scores[0] = highScore;
            myWriter.write("score="+ Arrays.toString(scores));
            if(score>highScore){
                highScore=score;
                myWriter.write("High Score ="+highScore);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void fileReader(){
        try{
            FileReader reader = new FileReader("filename.txt");
            reader.read();
            reader.close();
            System.out.println("read");
        }catch (IOException e){
            System.out.println("An error has occured");
            e.printStackTrace();
        }
    }
    public void getImageY(){
        if(chance==1){
            image1newY+=20;
        }
        if(chance==2){
            image2newY+=20;
        }
        if(chance==3){
            image3newY+=20;
        }
        if(chance==4){
            image4newY+=20;
        }
    }
}

