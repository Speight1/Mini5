/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Items.Sprite;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import Events.movement;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

import javax.swing.*;

/**
 *
 * @author 160289
 */
public class second extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    // private ImageIcon image;
    private final int delay = 5;
    public int x = 0;
    public int y = 0;
    public int velx = 0;
    public int vely = 0;


    public second() {
        setFocusTraversalKeysEnabled(false); // Disables keys such as 'TAB'
        setFocusable(true); // Set foucusable
        addKeyListener(this); // Adds The listener implemented

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Sprite s = new Sprite(4, 5, "id");

        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Ellipse2D.Double(x, y, 60, 60));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (x < 0 || x > 540) {
            x = -velx;
        }
        if (y < 0 || y > 440) {
            y = -vely;
        }

        x += velx;
        y += vely;
        System.out.print("X: " + x + "\t\t Y: " + y);
        repaint();
    }

@Override
    public void keyReleased(KeyEvent e) {
        velx = 0;
        vely = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e){
        
        int code = e.getKeyCode();
        
        if(code == VK_UP){
            vely += -1;
            velx += 0;
        }
        if(code == VK_DOWN){
            vely += 1;
            velx += 0;
        }        
        if(code == VK_LEFT){
            vely += 0;
            velx += -1;
        }
        if(code == VK_RIGHT){
            vely += 0;
            velx += 1;
        }
        
    }

}
