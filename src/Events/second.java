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
    private int delay = 50;
    private ImageIcon image;

    
    public second(){
        animator = new Timer(delay, this);
        animator.start();          
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Sprite s = new Sprite(4,5);
        image = new ImageIcon("C:\\Users\\Matthew\\Pictures\\arrow-50x50-md.png");
        image.paintIcon(this, g, (int) (Math.random() * 200),(int)(Math.random()*200));
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        repaint();
    }
    

}
