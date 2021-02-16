import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class HangManGameLevel1 extends JPanel implements KeyListener
{
    BankLetter [] letters;

    public HangManGameLevel1(){
        letters = new BankLetter[3];
        letters[0] = new BankLetter('A');
        letters[1] = new BankLetter('B');
        letters[2] = new BankLetter('C');
        letters[1].markAsGuessed(true);
        letters[2].markAsGuessed(false);
        
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        letters[0].paint(g, 0, 50);
        letters[1].paint(g, 50, 50);
        letters[2].paint(g, 100, 50);
        
        
    }
    
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        char c;
        c = e.getKeyChar();     
    }

    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        char c;
        c = e.getKeyChar();
        System.out.println("The button pressed is " + c);
        
    }


    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        char c;
        c = e.getKeyChar();
    }

     public static void main(String [] arg){
        JFrame runner = new JFrame("Level 1 Test");
        runner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.setLocationRelativeTo(null);
        runner.setSize(300, 300);
        runner.setLocation(0, 0);
        runner.setLayout(null);
        
        HangManGameLevel1 theGame = new HangManGameLevel1();
        theGame.setSize(800, 800);
        theGame.setLocation(0, 0);
        runner.getContentPane().add(theGame);
        
        runner.setVisible(true);

        runner.addKeyListener(theGame);
    }
}
