import java.awt.*;
public class SecretPhrase {
    private SecretLetter [] phrase;
    
    public SecretPhrase(String phrase) {
        this.phrase = new SecretLetter[phrase.length()];
        for(int i = 0; i < phrase.length(); i++){
            this.phrase[i] = new SecretLetter(phrase.charAt(i));
        }
        for(int i1 = 0; i1 < phrase.length(); i1++){
            if(this.phrase[i1].getLetter() == ' '){
                this.phrase[i1].reveal();
            }
        }
    }
    
    public boolean isInPhrase(char letter){
        for(int i = 0; i < phrase.length; i++){
            if(letter == phrase[i].getLetter()) {
                return true;
            }
        }
        return false;
    }   
    
    public void reveal(char letter) {
        for(int i = 0; i < phrase.length; i++){
            if(letter == phrase[i].getLetter()){
                phrase[i].reveal();
            }
        }
    }
    
    public void paint(Graphics g, int x, int y){
        for(int i = 0; i < phrase.length; i++){
            phrase[i].paint(g, x, y);
            x += 40;
            if((i+1) % 6 == 0){
                y += 40;
                x = x - 6 * 40;
            }
        }
    }
    
    public boolean isDone() {
        for(int i = 0; i < phrase.length; i++) {
            if(phrase[i].isGuessed() == false) {
                return false;
            }
        }
        return true;
    }
}
