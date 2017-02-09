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
    
    public int RefreshRate = 80;
    Timer timer;
    int x = 1, y = 1;
    
    int x2 =20, y2=20;
Image image;
    
    
    public Window(){
     timer = new Timer((1000/RefreshRate), (ActionListener) this);
        try{
           image = Toolkit.getDefaultToolkit().getImage("/Users/mathew/Downloads/15267607_1020864441374934_1345389097926564400_n.jpg");
        } catch(Exception e){}
        
        
    }
    public void paintComponent(Graphics g){
         Graphics2D graph = (Graphics2D) g;
       //  Image nimage = image.getScaledInstance(200, 200, Image.SCALE_FAST);
         
          graph.drawImage(image, x, y, this);
         graph.setStroke(new BasicStroke(5));
         Rectangle r = new Rectangle();
         r.setBounds(0, 0, x,y);
         graph.draw(r);
         graph.drawString("Where's the code Toby?", x+10, y-10);
         graph.drawLine(x2++ ,y2++,x++,y++);
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
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize().height, Toolkit.getDefaultToolkit().getScreenSize().width);
        
        f.add(w);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    
}
