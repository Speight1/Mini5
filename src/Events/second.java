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

import javax.swing.*;

/**
 *
 * @author 160289
 */
public class second extends JPanel implements ActionListener{

    private Timer timer;
    // private ImageIcon image;
    private final int delay = 5;
    public int x = 0;
    public int y = 0;
    public int velx = 2;
    public int vely = 3;

    public second() {
        setFocusTraversalKeysEnabled(false); // Disables keys such as 'TAB'
        setFocusable(true); // Set foucusable
        //addKeyListener(this); // Adds The listener implemented

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Sprite s = new Sprite(4, 5);

        s.g2 = (Graphics2D) g;
        s.g2.draw(new Ellipse2D.Double(x,y,60,60));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (x < 0 || x > 340) {
            x -= velx;
        }
        if (y < 0 || y > 540) {
            y -= vely;
        }

        x += velx;
        y += vely;
        System.out.print("X: " + x +"\t\t Y: " + y);
        repaint();
    }

    /*@Override
    public void keyReleased(KeyEvent e) {
        velx = 0;
        vely = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        movement m = new movement();

        if (code == m.UP) {
            up();
        }
        if (code == m.DOWN) {
            down();
        }
        if (code == m.RIGHT) {
            right();
        }
        if (code == m.LEFT) {
            left();
        }

    }

    public void up() {
        vely += -1;
        velx += 0;
    }

    public void down() {
        vely += 1;
        velx += 0;
    }

    public void right() {
        vely += 0;
        velx += 1;
    }

    public void left() {
        vely += 0;
        velx += -1;
    }
*/

}
