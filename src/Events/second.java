/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Items.Sprite;
import Items.Storage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 160289
 */
public class second extends JPanel implements ActionListener{
    private Timer animator;
   // private ImageIcon image;
    private int delay = 50, totalframe = 2, currentFrame;
    
    
    public void paintComponent(Graphics g){
         Sprite s = new Sprite(4,5);
        super.paintComponent(g);
    s.image = new ImageIcon("g");
    
   
   // Storage.LOCAL_STORAGE.sprites[1];
    s.image.paintIcon(this, g,s.spriteLocation.x,s.spriteLocation.y);
  //  s.setPos(7, 3);
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
