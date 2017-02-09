/*
This class stores the properties of the sprites
 */
package Items;

import java.awt.Point;

/**
 *
 * @author Computing Admin
 */
public class Sprite {
    public boolean spriteVisible = true; // Sets whether the sprite is visible, this will be used by toby when drawing the GUI
    public Point spriteLocation; // Stores the location, this will be used by Matt (S) when handling a change in sprite location
    
   public void setVisible(boolean visible){
       spriteVisible = visible; 
   }
    public Sprite (Point location){
        spriteLocation = location;
    }
    
    public Sprite(int xPos, int yPos){
        spriteLocation = new Point();
        setPos(xPos, yPos);
    }
     
    public Point getPos(){
        
        return spriteLocation;
    }
    
    public void setPos(int x, int y){
        spriteLocation.x =x;
        spriteLocation.x =y;
    }
    
  
    
    public static void main (String[] args){
        
       //To create a new sprite
       Sprite s = new Sprite(4,4);
       
       //To set it to a new location
       s.setPos(5, 7);
       s.setVisible(true);
    }
    
}
