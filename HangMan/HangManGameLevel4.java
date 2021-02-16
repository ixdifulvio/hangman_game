import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class HangManGameLevel4 extends JPanel implements KeyListener
{
    SecretPhrase phrase;

    public HangManGameLevel4(){
        phrase = new SecretPhrase("TO BE OR NOT TO BE");
        
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        phrase.paint(g, 10, 325);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        g.drawString("Phrase is \"TO BE OR NOT TO BE\". ", 0, 25);
        g.drawString("Press the space bar to reveal T and O and test isInPhrase", 0, 50);
        
    }
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        char c;
        c = e.getKeyChar(); 
        if(c == ' '){
            phrase.reveal('T');
            phrase.reveal('O');
            if(phrase.isInPhrase('Z')){
                System.out.println("Error - Z incorrectly found in phrase");
            }
            if(!phrase.isInPhrase('B')){
                System.out.println("Error - B not found in phrase");
            }
            if(!phrase.isInPhrase('Z') && phrase.isInPhrase('B')){
                System.out.println("isInPhrase appears to work");
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
        JFrame runner = new JFrame("Level 4 Test");
        runner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.setLocationRelativeTo(null);
        runner.setSize(700, 700);
        runner.setLocation(0, 0);
        runner.setLayout(null);
        
        HangManGameLevel4 theGame = new HangManGameLevel4();
        theGame.setSize(800, 800);
        theGame.setLocation(0, 0);
        runner.getContentPane().add(theGame);
        
        runner.setVisible(true);

        runner.addKeyListener(theGame);
    }
}