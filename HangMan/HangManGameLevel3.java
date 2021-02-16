import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class HangManGameLevel3 extends JPanel implements KeyListener
{
    LetterBank bank;

    public HangManGameLevel3(){
        bank = new LetterBank("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        bank.paint(g, 300, 50);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        g.drawString("Press the space bar to test and r to reset", 0, 350);
        String lettersToTest = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String availableLetters = "", unavailableLetters = "";
        for(int i = 0; i < lettersToTest.length(); i += 1){
            if(bank.isAvailable(lettersToTest.charAt(i))){
                availableLetters = availableLetters + lettersToTest.charAt(i);
            }else{
                unavailableLetters = unavailableLetters + lettersToTest.charAt(i);
            }
        }
        g.drawString("Available: " + availableLetters, 0, 380);
        g.drawString("Unavailable: " + unavailableLetters, 0, 410);
        
    }
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        char c;
        c = e.getKeyChar(); 
        if(c == ' '){
            String lettersToTest = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i = 0; i < lettersToTest.length() - 2; i += 3){
                bank.markAsGuessed(lettersToTest.charAt(i), true);
                bank.markAsGuessed(lettersToTest.charAt(i+1), false);
            }
        }else if(c == 'r' || c == 'R'){
            bank.reset();
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
        JFrame runner = new JFrame("Level 3 Test");
        runner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.setLocationRelativeTo(null);
        runner.setSize(700, 700);
        runner.setLocation(0, 0);
        runner.setLayout(null);
        
        HangManGameLevel3 theGame = new HangManGameLevel3();
        theGame.setSize(800, 800);
        theGame.setLocation(0, 0);
        runner.getContentPane().add(theGame);
        
        runner.setVisible(true);

        runner.addKeyListener(theGame);
    }
}