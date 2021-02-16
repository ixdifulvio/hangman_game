import java.awt.*;
public class LetterBank {
    private BankLetter [] alphabet;

    public LetterBank(String alphabet){
        this.alphabet = new BankLetter[alphabet.length()];
        for(int i = 0; i < alphabet.length(); i++){
            this.alphabet[i] = new BankLetter(alphabet.charAt(i));
        }
    }

    public void reset(){
        for(int i = 0; i < alphabet.length; i++){
            alphabet[i].reset();
        }
    }

    public boolean isAvailable(char letter){
        for(int i = 0; i < alphabet.length; i++){
            if(letter == alphabet[i].getLetter()){
                return !alphabet[i].isGuessed(); //negate because it returns true that it is guessed, but we want to know if it is available
            }
        }
        return true;
    }

    public boolean markAsGuessed(char letter, boolean isInPhrase){
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i].getLetter() == letter){
                alphabet[i].markAsGuessed(isInPhrase);
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics g, int x, int y){
        for(int i = 0; i < alphabet.length; i++){
            alphabet[i].paint(g, x, y);
            x += 40;
            if((i+1) % 6 == 0){
                y += 40;
                x = x - 6 * 40;
            }
        }
    }
    
}
