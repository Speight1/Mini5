/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Items.Sprite;
import Items.Storage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author mathew
 */
public class Processing {
    public static Color genColour(){
        int r = (int) (Math.random()*256);
        int g =(int) (Math.random()*256);
        int b = (int) (Math.random()*256);
        return new Color(r,g,b);
    }
    public static void drawSprite(Graphics2D graph, Sprite spr){
        int radius = (int) (Math.random()*20);
        Shape theCircle = new Ellipse2D.Double(spr.getPos().x - radius, spr.getPos().y - radius, 2.0 * radius, 2.0 * radius);
       graph.drawString(spr.sID, spr.spriteLocation.x +5, spr.spriteLocation.y+10);
        
        graph.setColor(genColour());
        graph.fill(theCircle);
        graph.draw(theCircle);
        
        
        
    }
    
    public static void drawStorage(Graphics2D graph, Storage stor){
        for(int i =0; i< stor.numberOfSprites; i++){
            drawSprite(graph, stor.sprites[i]);
            
        }
        
    }
    
}
