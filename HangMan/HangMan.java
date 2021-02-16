import java.awt.*;
import java.util.*;

public class HangMan{
    private int numParts;
    private int maxParts;
    private Color theColor;
    
    public HangMan(Color aColor) {
        theColor = aColor;
        maxParts = 6;
        reset();
    }
    
    public void reset(){
        numParts = 0;
    }
    
    public boolean isComplete(){
        if(numParts >= maxParts){
            return true;
        }
        return false;
    }
    
    public void addPart(){
        numParts += 1;
    }
    
    public void paint(Graphics g) {
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        //draw gallows
        g.setColor(Color.BLACK);
        g.drawRect(0, 250, 300, 50);
        g.drawLine(150, 250, 150, 0);
        g.drawLine(150, 0, 250, 0);
        g.drawLine(250, 0, 250, 50);
        //draw hangman
        if(numParts == 1){
            //draws head
            g.fillOval(225, 50, 50, 50);
        }
        if(numParts == 2){
            //draws head
            g.fillOval(225, 50, 50, 50);
            //draws body
            g.drawLine(250, 100, 250, 200);
        }
        if(numParts == 3){
            //draws head
            g.fillOval(225, 50, 50, 50);
            //draws body
            g.drawLine(250, 100, 250, 200);
            //draws left leg
            g.drawLine(250, 200, 225, 225);
        }
        if(numParts == 4){
            //draws head
            g.fillOval(225, 50, 50, 50);
            //draws body
            g.drawLine(250, 100, 250, 200);
            //draws left leg
            g.drawLine(250, 200, 225, 225);
            //draws right leg
            g.drawLine(250, 200, 275, 225);
        }
        if(numParts == 5){
            //draws head
            g.fillOval(225, 50, 50, 50);
            //draws body
            g.drawLine(250, 100, 250, 200);
            //draws left leg
            g.drawLine(250, 200, 225, 225);
            //draws right leg
            g.drawLine(250, 200, 275, 225);
            //draws left arm
            g.drawLine(250, 125, 225, 100);
        }
        if(numParts == 6){
            //draws head
            g.fillOval(225, 50, 50, 50);
            //draws body
            g.drawLine(250, 100, 250, 200);
            //draws left leg
            g.drawLine(250, 200, 225, 225);
            //draws right leg
            g.drawLine(250, 200, 275, 225);
            //draws left arm
            g.drawLine(250, 125, 225, 100);
            //draws right arm
            g.drawLine(250, 125, 275, 100);
        }
    }

} 
