import java.awt.*;
import java.util.*;
public class BankLetter {
    private char letter;
    private boolean guessed;
    private boolean correctlyGuessed;
    
    public BankLetter(char letter) {
        this.letter = letter;
        reset();
    }
    
    public void reset() {
        guessed = false;
        correctlyGuessed = false;
    }
    
    public char getLetter(){
        return letter;
    }
    
    public boolean isGuessed() {
        return guessed;
    }
    
    public boolean isCorrectlyGuessed() {
        return correctlyGuessed;
    }
    
    public void markAsGuessed(boolean isCorrect) {
        guessed = true;
        correctlyGuessed = isCorrect;
    }
    
    public void paint(Graphics g, int x, int y){
        g.setFont(new Font("Courier New", Font.BOLD, 60));
        if(guessed == false) {
            g.setColor(new Color(128, 128, 128));
            g.drawString("" + letter, x, y);
        } else {
            if(correctlyGuessed == false){
                g.setColor(Color.RED);
                g.drawString("" + letter, x, y);
            } else {
                g.setColor(Color.GREEN);
                g.drawString("" + letter, x, y);
            }
        }
        g.drawString("" + letter, x, y);
    }
    
}
