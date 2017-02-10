/*
This class stores the properties of the sprites
 */
package Items;

import GUI.Processing;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.Serializable;


/**
 *
 * @author Computing Admin
 */
public class Sprite implements Serializable{
    public String sID;
    public Color backColour = Processing.genColour();
    
    public Image image = null;
 
    public boolean spriteVisible = true; // Sets whether the sprite is visible, this will be used by toby when drawing the GUI
    public Point spriteLocation; // Stores the location, this will be used by Matt (S) when handling a change in sprite location
    
    
   
    public void setPicture(String directory){
        
       // image = new Image() {};
    }
    
   public void setBackground(Color colour){
       backColour = colour; 
   }
    
   public void setVisible(boolean visible){
       spriteVisible = visible; 
   }
    public Sprite (Point location, String ID){
        sID = ID;
        spriteLocation = location;
    }
    
    public Sprite(int xPos, int yPos, String ID){
         sID = ID;
        spriteLocation = new Point();
        setPos(xPos, yPos);
    }
     
    public Point getPos(){
        
        return spriteLocation;
    }
    
    public void setPos(int x, int y){
        spriteLocation.x =x;
        spriteLocation.y =y;
    }
    
  
    
    public static void main (String[] args){
        
       //To create a new sprite
       Sprite s = new Sprite(4,4,"");
       
       //To set it to a new location
       s.setPos(5, 7);
       s.setVisible(true);
    }
    
}
