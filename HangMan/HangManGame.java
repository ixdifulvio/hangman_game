import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class HangManGame extends JPanel implements KeyListener
{
    SecretPhrase phrase;
    private HangMan frank;
    private LetterBank bank;
    private boolean gameOver;

    public HangManGame(){
        bank = new LetterBank("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        frank = new HangMan(Color.BLUE);
        gameOver = false;
        setPhrase();
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        phrase.paint(g, 10, 325);
        frank.paint(g);
        bank.paint(g, 300, 50);
        
        if(gameOver == true && frank.isComplete() == false) {
            g.setFont(new Font("Courier New", Font.BOLD, 40));
            g.setColor(Color.BLACK);
            g.drawString("Congratulations! You Win!", 10, 500);
        }
        if(gameOver == true && frank.isComplete() == true){
            g.setFont(new Font("Courier New", Font.BOLD, 40));
            g.setColor(Color.BLACK);
            g.drawString("Wow you suck...You lost!", 10, 500);
        }
        
    }
    
    public void setPhrase(){
        String text = JOptionPane.showInputDialog("What is the next secret phrase?");
        phrase = new SecretPhrase(text.toUpperCase());
    }
         
    
    public void reset(){
        frank.reset();
        bank.reset();
        gameOver = false;
        setPhrase();
    }
    
    public void play(char c){
        if(bank.isAvailable(c) == true){
            if(phrase.isInPhrase(c) == false) {
                frank.addPart();
                bank.markAsGuessed(c, false);
            } else {
                phrase.reveal(c);
                bank.markAsGuessed(c, true);
            }
        }
        if(phrase.isDone() == true || frank.isComplete() == true){
            gameOver = true;
        } 
    }
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        char c;
        c = e.getKeyChar();
        String letter = "" + c;
        letter = letter.toUpperCase();
        c = letter.charAt(0);
        if(!gameOver){
            play(c);
        }
        if(c == ' '){
            reset();
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
        JFrame runner = new JFrame("Hang Man");
        runner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.setLocationRelativeTo(null);
        runner.setSize(700, 700);
        runner.setLocation(0, 0);
        runner.setLayout(null);
        
        HangManGame theGame = new HangManGame();
        theGame.setSize(800, 800);
        theGame.setLocation(0, 0);
        runner.getContentPane().add(theGame);
        
        runner.setVisible(true);

        runner.addKeyListener(theGame);
    }
}