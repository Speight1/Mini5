/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import Items.Sprite;
import Items.Storage;
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
import java.util.Random;
import javax.imageio.ImageIO;

import javax.swing.*;

/**
 *
 * @author mathew
 */
public class Window extends JPanel implements ActionListener{

    public int RefreshRate = 30;
    Timer timer;

    public Window(){
     timer = new Timer((1000/RefreshRate), (ActionListener) this);
      
        
        
    }
    public void paintComponent(Graphics g){
         Graphics2D graph = (Graphics2D) g;
        Processing.drawStorage(graph, Storage.LOCAL_STORAGE);
         graph.finalize();
           timer.start();
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
      
       
       repaint();
      
    }
    
    public static void main(String[] args){
        System.out.println("Starting");
        
        Storage.LOCAL_STORAGE = new Storage(10000);
        Storage.LOCAL_STORAGE.addNewSprite(new Sprite(400,400, "Mathew"));
        Storage.LOCAL_STORAGE.addNewSprite(new Sprite(20,20, "Toby"));
        
        
        new Thread(new Runnable(){public void run(){
            int i =1;
        while(true){
                   Storage.LOCAL_STORAGE.addNewSprite(new Sprite(new Random().nextInt(500),new Random().nextInt(500),"Sprite"+i));
            try{Thread.sleep(10);}catch(Exception e){} i++; 
            
        }
        
        
        
        }}).start();
        
        
        Window w = new Window();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        w.setBounds(f.getBounds());
        f.add(w);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    
}
