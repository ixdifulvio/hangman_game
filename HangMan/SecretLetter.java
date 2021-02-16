import java.awt.*;
public class SecretLetter {
    private char letter;
    private boolean guessed;

    public SecretLetter(char letter){
        this.letter = letter;
        guessed = false;
    }

    public void reveal (){
        guessed = true;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void paint(Graphics g, int x, int y){
        if(isGuessed() == false){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString("" + "_", x, y);
        }else{
            g.setColor(Color.BLUE);
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString("" + getLetter(), x, y);
        }
    }

}
