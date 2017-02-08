/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author 160289
 */
public class pic extends JPanel{
    private ImageIcon image;
    
    public void createImage(Graphics g){
        super.paintComponent(g);
        image = new ImageIcon("");
    }
}
