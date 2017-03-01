/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class animator {
    
    public volatile boolean running;
    public ArrayList<BufferedImage> Frames;
    
    public int currentFrame;
    private long speed, lastTime;
    
    public animator(ArrayList<BufferedImage> Frames){
        this.Frames = Frames;
    }
    
    public void update(long time){
        if(running){
            // Check if within curretn fps rate
            //update the sprite - make new Buffered image **
            //update lastTime to currentTime (time)
        }        
    }
    
    public void start(){ //trigger
        running = true;
        currentFrame = 0;
        lastTime = 0;
    }
        
    
}
