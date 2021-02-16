import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class HangManGameLevel2 extends JPanel implements KeyListener
{
    private HangMan frank;

    public HangManGameLevel2(){
        frank = new HangMan(Color.BLUE); 
    }

    public void paint(Graphics g){
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.drawString("Press the space bar to add part", 0, 350);
        if(frank.isComplete()){
            g.drawString("Hang Man is complete", 0, 400);
        }
        frank.paint(g);
    }
    
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        char c;
        c = e.getKeyChar(); 
        if(c == ' '){
            if(!frank.isComplete()){
                frank.addPart();
            }
        }
        
        repaint();
    }

    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        char c;
        c = e.getKeyChar();        
    }


    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        char c;
        c = e.getKeyChar();
    }

     public static void main(String [] arg){
        JFrame runner = new JFrame("Level 2 Test");
        runner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.setLocationRelativeTo(null);
        runner.setSize(700, 700);
        runner.setLocation(0, 0);
        runner.setLayout(null);
        
        HangManGameLevel2 theGame = new HangManGameLevel2();
        theGame.setSize(800, 800);
        theGame.setLocation(0, 0);
        runner.getContentPane().add(theGame);
        
        runner.setVisible(true);

        runner.addKeyListener(theGame);
    }
}
