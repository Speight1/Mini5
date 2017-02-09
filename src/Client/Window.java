/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*;

/**
 *
 * @author mathew
 */
public class Window extends JPanel implements ActionListener{
    Rectangle bounds = this.getBounds();
    public int RefreshRate = 80;
    Timer timer;
    int x = 1, y = 1;
    
    int x2 =20, y2=20;
Image image;
    int velocX = 3, velocY =3;
    
    public Window(){
     timer = new Timer((1000/RefreshRate), (ActionListener) this);
        try{
           image = Toolkit.getDefaultToolkit().getImage("/Users/mathew/Downloads/15895042_1710717915620850_3791381426811506760_n.jpg");
        } catch(Exception e){}
        
        
    }
    public void paintComponent(Graphics g){
         Graphics2D graph = (Graphics2D) g;
        
           if((x>=500|| x<=0)||(x2>=500 || x2<=0)){
             System.out.println("Bounce!");
             velocX = -velocX;
         }
         
         if((y>=500 || y<=0)||(y2>=400|| y2<=0)){
             System.out.println("Bounce!");
              velocY = -velocY;
         }
        
         graph.setStroke(new BasicStroke(5));
         Rectangle r = new Rectangle();
        
         graph.draw(r);
         graph.drawString("Sprite Number 1", x+10, y-10);
         graph.drawImage(image, x, y, this);
         graph.drawOval(x, y, WIDTH, velocX);
         
         graph.drawLine(x2+=velocX ,y2+=velocY,x+=velocX,y+=velocY); 
         
         graph.finalize();
           timer.start();
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
      
    
       repaint();
      
    }
    
    public static void main(String[] args){
        System.out.println("Starting");
        Window w = new Window();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        w.setBounds(f.getBounds());
        f.add(w);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    
}
