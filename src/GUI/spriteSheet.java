/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.image.BufferedImage;

/**
 *
 * @author Matthew
 */
public class spriteSheet {
    
    private BufferedImage spriteSheet;
    
    public spriteSheet(BufferedImage SpriteS){
        this.spriteSheet = SpriteS;
    }
    
    public BufferedImage getSprite(int x, int y, int width, int hight){
        BufferedImage sprite = spriteSheet.getSubimage(x, y, width, hight);
        return sprite;
    }
    
    
}
