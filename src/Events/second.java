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
    private Sprite s = new Sprite(4,5);
    private ImageIcon[] images;
    
    public second(){
        for(int i = 0; i<images.length; i++){
            images[i] = new ImageIcon("frame"+i+".jpg");
        } // 3.24 sconds on vid (https://www.youtube.com/watch?v=JyVguDOXCuM&t=99s)
    }
    
    
}
